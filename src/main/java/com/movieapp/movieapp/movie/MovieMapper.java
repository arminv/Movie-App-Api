package com.movieapp.movieapp.movie;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.movieapp.movieapp.mappers.Mapper;

@Component
public class MovieMapper implements Mapper<Movie, MovieDto> {

    private final ModelMapper modelMapper;

    MovieMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MovieDto mapTo(final Movie movie) {
        if (movie == null) {
            throw new NullPointerException("movie is null");
        }
        return modelMapper.map(movie, MovieDto.class);
    }

    @Override
    public Movie mapFrom(final MovieDto movieDto) {
        if (movieDto == null) {
            throw new NullPointerException("movieDto is null");
        }

        return modelMapper.map(movieDto, Movie.class);
    }

}
