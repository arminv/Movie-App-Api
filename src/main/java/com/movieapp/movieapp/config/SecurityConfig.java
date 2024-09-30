package com.movieapp.movieapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2SuccessHandler customOAuth2SuccessHandler;

    public SecurityConfig(CustomOAuth2SuccessHandler customOAuth2SuccessHandler) {
        this.customOAuth2SuccessHandler = customOAuth2SuccessHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> {
//                TODO:
                auth.requestMatchers("**").permitAll();
//                auth
//                    .requestMatchers("/", "/login", "/oauth2/**").permitAll(); // Public URLs
//                auth
//                    .anyRequest().authenticated(); // All other URLs require authentication
            })
            .oauth2Login(oauth2 -> oauth2
                .successHandler(customOAuth2SuccessHandler) // Use custom success handler
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")); // Redirect to home on logout

        return http.build();
    }

}
