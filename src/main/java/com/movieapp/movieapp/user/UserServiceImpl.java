package com.movieapp.movieapp.user;


import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Service
@AllArgsConstructor
@Log
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> getUserById(final String userId) {
        return userRepository.findById(userId);
    }

    //    TODO: deprecate this if not supporting form-based at all
    @Override
    public User createUpdateUser(final String userId, final CreateUpdateUserRequest createUpdateUserRequest) {
        final String finalUserId = Objects.requireNonNullElse(userId, "");
        final LocalDateTime now = LocalDateTime.now();

        return userRepository.findById(finalUserId).map(
            existingUser -> {
                // Update the existing User
                final User updatedUser = User.builder()
                    .id(finalUserId)
                    .name(createUpdateUserRequest.getName())
                    .email(createUpdateUserRequest.getEmail())
                    .avatarUrl(existingUser.getAvatarUrl())
                    .created(existingUser.getCreated())
                    .lastUpdated(now)
                    .build();

                return userRepository.save(updatedUser);
            }).orElseGet(() -> {
            // Create a new User
            final User newUser = User.builder()
                .name(createUpdateUserRequest.getName())
                .email(createUpdateUserRequest.getEmail())
                .avatarUrl("")
                .created(now)
                .lastUpdated(now)
                .build();

            return userRepository.save(newUser);
        });
    }

    @Override
    public void createUpdateOAuth2User(final OAuth2User oAuth2User) {
        final String email = Objects.requireNonNull(oAuth2User.getAttribute("email"));
        final LocalDateTime now = LocalDateTime.now();

        // Check if user exists:
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            existingUser.get().setLastLoggedInOn(now);
            userRepository.save(existingUser.get());
            return;
        }

        // If not, create a new user:
        final String name = Objects.requireNonNull(oAuth2User.getAttribute("name"));
        final User newUser = User.builder()
            .name(name)
            .email(email)
            .avatarUrl(oAuth2User.getAttribute("avatar_url"))
            .created(now)
            .lastUpdated(now)
            .lastLoggedInOn(now)
            .build();

        userRepository.save(newUser);
    }

    @Override
    public void deleteUser(final String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Map<String, Object> getUserInfo(final @AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttributes();
    }

}
