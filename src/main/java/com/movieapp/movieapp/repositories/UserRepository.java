package com.movieapp.movieapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.movieapp.movieapp.domain.documents.User;

public interface UserRepository extends MongoRepository<User, String> {

}
