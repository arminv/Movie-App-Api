package com.movieapp.movieapp;

import java.time.LocalDateTime;

import com.movieapp.movieapp.user.User;

public final class TestDataUtil {

    private TestDataUtil() {
    }

    public static User createTestUserEntityA() {
        final LocalDateTime dateCreated = LocalDateTime.parse("2024-10-11T18:34:14.406");
        return User.builder()
            .name("Armin")
            .email("arminvarshokar+test@gmail.com")
            .created(dateCreated)
            .lastUpdated(dateCreated)
            .build();
    }

}
