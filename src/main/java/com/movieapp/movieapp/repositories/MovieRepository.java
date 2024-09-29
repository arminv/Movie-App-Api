package com.movieapp.movieapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.movieapp.movieapp.domain.documents.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> getMoviesByUserId(String userId);

}
