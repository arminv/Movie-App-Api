package com.movieapp.movieapp.config;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.movieapp.movieapp.services.UserService;

@Component
public class CustomOAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final UserService userService;

    public CustomOAuth2SuccessHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        // Extract user details from the OAuth2User
        OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();

        // Call the service to save or update user information in MongoDB
        userService.saveOAuth2User(oauthUser);

        // Redirect to home page or any other page
        response.sendRedirect("/users/user");
    }

}
