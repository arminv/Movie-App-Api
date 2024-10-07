package com.movieapp.movieapp.user;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface UserService {

    Optional<User> getUserById(final String userId);

    User createUpdateUser(final String userId, final CreateUpdateUserRequest createUpdateUserRequest);

    void createUpdateOAuth2User(final OAuth2User oAuth2User);

    void deleteUser(final String userId);

    Map<String, Object> getUserInfo(final @AuthenticationPrincipal OAuth2User principal);

    Map<String, Object> getUserStatistics(final String userId);

}
