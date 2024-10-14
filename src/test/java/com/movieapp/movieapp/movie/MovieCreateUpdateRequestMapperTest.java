package com.movieapp.movieapp.movie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.movieapp.movieapp.mappers.Mapper;

//TODO:
class MovieCreateUpdateRequestMapperTest {

    private Mapper<CreateUpdateMovieRequest, CreateUpdateMovieRequestDto> movieCreateUpdateRequestMapper;

    @BeforeEach
    public void setUp() {
        this.movieCreateUpdateRequestMapper = new MovieCreateUpdateRequestMapper(new ModelMapper());
    }

    @Test
    void testMapTo() {
        System.out.println("mapTo TEST!");
    }

    @Test
    void testMapFrom() {
        System.out.println("mapFrom TEST!");
    }

}
