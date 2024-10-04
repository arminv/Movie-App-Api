package com.movieapp.movieapp.movie;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> getMoviesByUserId(String userId);

}
