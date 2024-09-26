package com.movieapp.movieapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.movieapp.movieapp.domain.documents.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {

}
