package com.movieapp.movieapp.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

    Page<Movie> findByUserId(final String userId, final Pageable pageable);

}
