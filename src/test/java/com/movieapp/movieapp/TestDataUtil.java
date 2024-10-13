package com.movieapp.movieapp;

import java.time.LocalDateTime;

import com.movieapp.movieapp.movie.Movie;
import com.movieapp.movieapp.movie.MovieDto;
import com.movieapp.movieapp.user.User;

public final class TestDataUtil {

    final static String TEST_USER_ID = "54hh849n9on7bu56uberf";

    private TestDataUtil() {
    }

    public static User createTestUserEntityA() {
        final LocalDateTime dateCreated = LocalDateTime.parse("2024-10-11T18:34:14.406");

        return User.builder()
            .id(TEST_USER_ID)
            .name("Armin")
            .email("arminvarshokar+test123@gmail.com")
            .created(dateCreated)
            .lastUpdated(dateCreated)
            .build();
    }

    public static Movie createTestMovieEntityA() {
        final LocalDateTime dateCreated = LocalDateTime.parse("2020-01-07T11:21:12.103");

        return Movie.builder()
            .id("39vkjwlc02jfg9ejhv9evce")
            .name("Harry Potter")
            .userId(TEST_USER_ID)
            .movieDBId("29jh23iv92cjo")
            .created(dateCreated)
            .lastUpdated(dateCreated)
            .dateWatched(dateCreated)
            .rating(3.5f)
            .review("Not a bad movie at all!")
            .build();
    }

    public static MovieDto createTestMovieDtoA() {
        final LocalDateTime dateCreated = LocalDateTime.parse("2017-03-01T10:10:10.100");

        return MovieDto.builder()
            .id("39gjw9f93jgbnwcvdv023")
            .name("The Green Mile")
            .userId(TEST_USER_ID)
            .movieDBId("20vkbw94ngswom")
            .created(dateCreated)
            .lastUpdated(dateCreated)
            .dateWatched(dateCreated)
            .rating(5.0f)
            .review("One of the best movies ever!")
            .build();
    }

    public static MovieDto createTestMovieDtoB() {
        final LocalDateTime dateCreated = LocalDateTime.parse("2014-01-05T11:11:11.200");

        return MovieDto.builder()
            .id("39vmwm39fjswivb33mvw0")
            .name("Forrest Gump")
            .userId(TEST_USER_ID)
            .movieDBId("oo29dfcn330k-")
            .created(dateCreated)
            .lastUpdated(dateCreated)
            .dateWatched(dateCreated)
            .rating(4.5f)
            .review("One of the best movies!")
            .build();
    }

}
