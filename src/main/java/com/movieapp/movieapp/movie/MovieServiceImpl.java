package com.movieapp.movieapp.movie;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    public Page<Movie> getMoviesByUserId(final String userId, final int page, final int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return movieRepository.findByUserId(userId, pageRequest);
    }

    @Override
    public void deleteMovie(final String movieId) {
        movieRepository.deleteById(movieId);
    }

}
