package com.movieapp.movieapp.movie;

import java.util.List;

public interface MovieService {

    Movie createUpdateMovie(final String movieId, final CreateUpdateMovieRequest createUpdateMovieRequest);

    void deleteMovie(final String movieId);

    List<Movie> getMoviesByUserId(final String userId);

}
