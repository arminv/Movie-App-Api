package com.movieapp.movieapp.services;


import com.movieapp.movieapp.domain.CreateUpdateUserRequest;
import com.movieapp.movieapp.domain.documents.User;

public interface UserService {

    User createUpdateUser(String userId, CreateUpdateUserRequest createUpdateUserRequest);

}
