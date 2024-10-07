package com.movieapp.movieapp.movie;

import java.util.List;

import org.springframework.data.domain.Page;

public interface MovieService {

    Movie createUpdateMovie(final String movieId, final CreateUpdateMovieRequest createUpdateMovieRequest);

    void deleteMovie(final String movieId);

    Page<Movie> getMoviesByUserId(final String userId, final int page, final int pageSize, final String sortBy, final String sortDirection);

    List<Movie> getAllMoviesByUserId(final String userId);

}
