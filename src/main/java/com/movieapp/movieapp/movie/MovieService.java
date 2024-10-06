package com.movieapp.movieapp.movie;

import org.springframework.data.domain.Page;

public interface MovieService {

    Movie createUpdateMovie(final String movieId, final CreateUpdateMovieRequest createUpdateMovieRequest);

    void deleteMovie(final String movieId);

    Page<Movie> getMoviesByUserId(final String userId,  final int page, final int pageSize);

}
