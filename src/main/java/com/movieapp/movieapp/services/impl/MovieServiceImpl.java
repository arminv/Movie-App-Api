package com.movieapp.movieapp.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.movieapp.movieapp.domain.CreateUpdateMovieRequest;
import com.movieapp.movieapp.domain.documents.Movie;
import com.movieapp.movieapp.repositories.MovieRepository;
import com.movieapp.movieapp.services.MovieService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Service
@AllArgsConstructor
@Log
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    @Override
    public Movie createUpdateMovie(final String movieId, final CreateUpdateMovieRequest createUpdateMovieRequest) {
        final String finalMovieId = Objects.requireNonNullElse(movieId, "");

        return movieRepository.findById(finalMovieId).map(
            existingMovie -> {
                // Update the existing Movie
                final Movie updatedMovie = Movie.builder()
                    .id(finalMovieId)
                    .movieDBId(createUpdateMovieRequest.getMovieDBId())
                    .userId(createUpdateMovieRequest.getUserId())
                    .name(createUpdateMovieRequest.getName())
                    .created(existingMovie.getCreated())
                    .lastUpdated(LocalDateTime.now())
                    .build();

                return movieRepository.save(updatedMovie);
            }).orElseGet(() -> {
            // Create a new Movie
            final LocalDateTime now = LocalDateTime.now();
            final Movie newMovie = Movie.builder()
                .movieDBId(createUpdateMovieRequest.getMovieDBId())
                .userId(createUpdateMovieRequest.getUserId())
                .name(createUpdateMovieRequest.getName())
                .created(now)
                .lastUpdated(now)
                .build();

            return movieRepository.save(newMovie);
        });
    }

    @Override
    public List<Movie> getMoviesByUserId(final String userId) {
        return movieRepository.getMoviesByUserId(userId);
    }

    @Override
    public void deleteMovie(final String movieId) {
        movieRepository.deleteById(movieId);
    }

}
