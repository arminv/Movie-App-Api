package com.movieapp.movieapp.services;

import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.movieapp.movieapp.domain.CreateUpdateUserRequest;
import com.movieapp.movieapp.domain.documents.User;

public interface UserService {

    Optional<User> getUserById(final String userId);

    User createUpdateUser(final String userId, final CreateUpdateUserRequest createUpdateUserRequest);

    void saveOAuth2User(final OAuth2User oAuth2User);

    void deleteUser(final String userId);

    String getUserInfo(final @AuthenticationPrincipal OAuth2User principal);

}
