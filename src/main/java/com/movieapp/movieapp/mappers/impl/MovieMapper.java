package com.movieapp.movieapp.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.movieapp.movieapp.domain.documents.Movie;
import com.movieapp.movieapp.domain.dtos.MovieDto;
import com.movieapp.movieapp.mappers.Mapper;

@Component
public class MovieMapper implements Mapper<Movie, MovieDto> {

    private final ModelMapper modelMapper;

    MovieMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MovieDto mapTo(final Movie movie) {
        return modelMapper.map(movie, MovieDto.class);
    }

    @Override
    public Movie mapFrom(final MovieDto movieDto) {
        return modelMapper.map(movieDto, Movie.class);
    }

}
