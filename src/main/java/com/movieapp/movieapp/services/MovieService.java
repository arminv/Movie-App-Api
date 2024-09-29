package com.movieapp.movieapp.services;

import com.movieapp.movieapp.domain.CreateUpdateMovieRequest;
import com.movieapp.movieapp.domain.documents.Movie;

public interface MovieService {

    Movie createUpdateMovie(final String movieId, final CreateUpdateMovieRequest createUpdateMovieRequest);

}
