package com.movieapp.movieapp.movie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.movieapp.movieapp.TestDataUtil;
import com.movieapp.movieapp.mappers.Mapper;

class MovieCreateUpdateRequestMapperTest {

    private Mapper<CreateUpdateMovieRequest, CreateUpdateMovieRequestDto> movieCreateUpdateRequestMapper;

    @BeforeEach
    public void setUp() {
        this.movieCreateUpdateRequestMapper = new MovieCreateUpdateRequestMapper(new ModelMapper());
    }

    @Test
    public void testMapTo() {
        CreateUpdateMovieRequest requestA = TestDataUtil.createTestMovieRequestA();
        CreateUpdateMovieRequestDto requestDtoA = TestDataUtil.createTestMovieRequestDtoA();
        CreateUpdateMovieRequestDto result = this.movieCreateUpdateRequestMapper.mapTo(requestA);

        assertEquals(requestDtoA, result);
    }

    @Test
    public void testMapFrom() {
        CreateUpdateMovieRequestDto requestDtoA = TestDataUtil.createTestMovieRequestDtoA();
        CreateUpdateMovieRequest requestA = TestDataUtil.createTestMovieRequestA();
        CreateUpdateMovieRequest result = this.movieCreateUpdateRequestMapper.mapFrom(requestDtoA);

        assertEquals(requestA, result);
    }

    @Test
    public void testMapToThrowsWhenPassedNull() {
        NullPointerException exp = assertThrows(NullPointerException.class, () -> this.movieCreateUpdateRequestMapper.mapTo(null));
        assertEquals("createUpdateMovieRequest is null", exp.getMessage());
    }

    @Test
    public void testMapFromThrowsWhenPassedNull() {
        NullPointerException exp = assertThrows(NullPointerException.class, () -> this.movieCreateUpdateRequestMapper.mapFrom(null));
        assertEquals("createUpdateMovieRequestDto is null", exp.getMessage());
    }


}
