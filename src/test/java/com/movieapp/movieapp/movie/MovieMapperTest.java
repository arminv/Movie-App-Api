package com.movieapp.movieapp.movie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.movieapp.movieapp.TestDataUtil;
import com.movieapp.movieapp.mappers.Mapper;

class MovieMapperTest {

    private Mapper<Movie, MovieDto> movieMapper;

    @BeforeEach
    public void setUp() {
        this.movieMapper = new MovieMapper(new ModelMapper());
    }

    @Test
    public void testMapTo() {
        Movie movieB = TestDataUtil.createTestMovieEntityB();
        MovieDto movieDtoB = TestDataUtil.createTestMovieDtoB();
        MovieDto result = this.movieMapper.mapTo(movieB);

        assertEquals(movieDtoB, result);
    }

    @Test
    public void testMapFrom() {
        MovieDto movieDtoA = TestDataUtil.createTestMovieDtoA();
        Movie movieA = TestDataUtil.createTestMovieEntityA();
        Movie result = this.movieMapper.mapFrom(movieDtoA);

        assertEquals(movieA, result);
    }

    @Test
    public void testMapToThrowsWhenPassedNull() {
        NullPointerException exp = assertThrows(NullPointerException.class, () -> this.movieMapper.mapTo(null));
        assertEquals("movie is null", exp.getMessage());
    }

    @Test
    public void testMapFromThrowsWhenPassedNull() {
        NullPointerException exp = assertThrows(NullPointerException.class, () -> this.movieMapper.mapFrom(null));
        assertEquals("movieDto is null", exp.getMessage());
    }

}
