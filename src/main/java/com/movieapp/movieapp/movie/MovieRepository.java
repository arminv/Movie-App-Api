package com.movieapp.movieapp.movie;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findByUserId(final String userId);

    Page<Movie> findByUserId(final String userId, final Pageable pageable);

}
