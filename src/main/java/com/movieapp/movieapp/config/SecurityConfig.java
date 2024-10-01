package com.movieapp.movieapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

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
            .csrf(c -> c
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            )
            .oauth2Login(oauth2 -> oauth2
                .successHandler(customOAuth2SuccessHandler) // Use custom success handler
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .permitAll()); // Redirect to home on logout

//        TODO: only for testing purposes!
//        http.csrf().disable();

        return http.build();
    }

}
