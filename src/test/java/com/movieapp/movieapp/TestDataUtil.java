package com.movieapp.movieapp;

import java.time.LocalDateTime;

import com.movieapp.movieapp.movie.Movie;
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

    public static Movie createTestMovieEntityA() {
        final LocalDateTime dateCreated = LocalDateTime.parse("2020-01-07T11:21:12.103");

        return Movie.builder()
            .id("39vkjwlc02jfg9ejhv9evce")
            .name("Harry Potter")
            .userId("54hh849n9on7bu56uberf")
            .movieDBId("29jh23iv92cjo")
            .created(dateCreated)
            .lastUpdated(dateCreated)
            .dateWatched(dateCreated)
            .rating(3.5f)
            .review("Not a bad movie at all!")
            .build();
    }

}
