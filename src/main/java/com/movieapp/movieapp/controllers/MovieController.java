package com.movieapp.movieapp.controllers;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.movieapp.movieapp.domain.CreateUpdateMovieRequest;
import com.movieapp.movieapp.domain.documents.Movie;
import com.movieapp.movieapp.domain.dtos.CreateUpdateMovieRequestDto;
import com.movieapp.movieapp.domain.dtos.MovieDto;
import com.movieapp.movieapp.mappers.Mapper;
import com.movieapp.movieapp.services.MovieService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/movies")
public class MovieController {

    private MovieService movieService;

    private Mapper<Movie, MovieDto> movieMapper;

    private Mapper<CreateUpdateMovieRequest, CreateUpdateMovieRequestDto> createUpdateRequestMapper;

    @PutMapping(value = {"/{id}", "/"})
    public MovieDto createUpdateMovie(
        @PathVariable(required = false) final String id,
        @RequestBody final CreateUpdateMovieRequestDto requestBody
    ) {
        final CreateUpdateMovieRequest createUpdateMovieRequest = createUpdateRequestMapper.mapFrom(requestBody);

        try {
            final Movie createUpdatedMovie = movieService.createUpdateMovie(id, createUpdateMovieRequest);
            return movieMapper.mapTo(createUpdatedMovie);
        } catch (DuplicateKeyException e) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, "Movie already exists", e);
        }
    }

    @GetMapping("/user/{userId}")
    public List<MovieDto> getMoviesByUserId(@PathVariable final String userId) {
        return movieService.getMoviesByUserId(userId)
            .stream()
            .map(movieMapper::mapTo)
            .toList();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteMovie(@PathVariable final String id) {
        movieService.deleteMovie(id);
    }

}
