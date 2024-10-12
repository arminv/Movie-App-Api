package com.movieapp.movieapp;

import java.time.LocalDateTime;

import com.movieapp.movieapp.user.User;

public final class TestDataUtil {

    private TestDataUtil() {
    }

    public static User createTestUserEntityA() {
        final LocalDateTime dateCreated = LocalDateTime.parse("2024-10-11T18:34:14.406");

        return User.builder()
            .id("54hh849n9on7bu56uberf")
            .name("Armin")
            .email("arminvarshokar+test123@gmail.com")
            .created(dateCreated)
            .lastUpdated(dateCreated)
            .build();
    }

    public static User createTestUserEntityB() {
        final LocalDateTime dateCreated = LocalDateTime.parse("2022-04-08T17:22:12.121");

        return User.builder()
            .id("3kfss92jrfgabfjewi2dcov")
            .name("Armin2")
            .email("arminvarshokar+test456@gmail.com")
            .created(dateCreated)
            .lastUpdated(dateCreated)
            .build();
    }

}
