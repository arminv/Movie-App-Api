package com.movieapp.movieapp.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        final String targetMovieId = Objects.requireNonNullElse(movieId, "");

        return movieRepository.findById(targetMovieId).map(
            existingMovie -> {
                // Update the existing Movie
                final Movie updatedMovie = Movie.builder()
                    .id(targetMovieId)
                    .movieDBId(createUpdateMovieRequest.getMovieDBId())
                    .userId(createUpdateMovieRequest.getUserId())
                    .name(Optional.ofNullable(createUpdateMovieRequest.getName()).orElseGet(existingMovie::getName))
                    .created(existingMovie.getCreated())
                    .lastUpdated(LocalDateTime.now())
                    .rating(createUpdateMovieRequest.getRating() == 0f ? existingMovie.getRating() : createUpdateMovieRequest.getRating())
                    .review(Optional.ofNullable(createUpdateMovieRequest.getReview()).orElseGet(existingMovie::getReview))
                    .build();

                return movieRepository.save(updatedMovie);
            }).orElseGet(() -> {
            // Create a new Movie
            final LocalDateTime now = LocalDateTime.now();
            final Movie newMovie = Movie.builder()
                .movieDBId(createUpdateMovieRequest.getMovieDBId())
                .userId(createUpdateMovieRequest.getUserId())
                .name(Optional.ofNullable(createUpdateMovieRequest.getName()).orElse(""))
                .created(now)
                .lastUpdated(now)
                .rating(createUpdateMovieRequest.getRating())
                .review(Optional.ofNullable(createUpdateMovieRequest.getReview()).orElse(""))
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
