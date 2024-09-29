package com.movieapp.movieapp.services;

import java.util.List;

import com.movieapp.movieapp.domain.CreateUpdateMovieRequest;
import com.movieapp.movieapp.domain.documents.Movie;

public interface MovieService {

    Movie createUpdateMovie(final String movieId, final CreateUpdateMovieRequest createUpdateMovieRequest);

    void deleteMovie(String movieId);

    List<Movie> getMoviesByUserId(String userId);

}
