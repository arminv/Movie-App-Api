package com.movieapp.movieapp.services.impl;


import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;


import com.movieapp.movieapp.domain.CreateUpdateUserRequest;
import com.movieapp.movieapp.domain.documents.User;
import com.movieapp.movieapp.repositories.UserRepository;
import com.movieapp.movieapp.services.UserService;

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

    @Override
    public User createUpdateUser(final String userId, final CreateUpdateUserRequest createUpdateUserRequest) {
        try {
            final String finalUserId = Objects.requireNonNullElse(userId, "");

            return userRepository.findById(finalUserId).map(
                existingUser -> {
                    // Update the existing User
                    final User updatedUser = User.builder()
                        .id(finalUserId)
                        .name(createUpdateUserRequest.getName())
                        .email(createUpdateUserRequest.getEmail())
                        .created(existingUser.getCreated())
                        .lastUpdated(LocalDateTime.now())
                        .build();

                    return userRepository.save(updatedUser);
                }).orElseGet(() -> {
                // Create a new User
                final LocalDateTime now = LocalDateTime.now();
                final User newUser = User.builder()
                    .name(createUpdateUserRequest.getName())
                    .email(createUpdateUserRequest.getEmail())
                    .created(now)
                    .lastUpdated(now)
                    .build();

                return userRepository.save(newUser);
            });
        } catch (DuplicateKeyException e) {
            log.warning(e.getMessage());
            throw new DuplicateKeyException("User already exists");
        }
    }

    @Override
    public void deleteUser(final String userId) {
        userRepository.deleteById(userId);
    }

}
