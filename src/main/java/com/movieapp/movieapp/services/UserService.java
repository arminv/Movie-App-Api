package com.movieapp.movieapp.services;

import com.movieapp.movieapp.domain.CreateUpdateUserRequest;
import com.movieapp.movieapp.domain.documents.User;

public interface UserService {

//    TODO
//    Optional<User> getUserById(String userId);
//
//    void deleteUser(String userId);

    User createUpdateUser(final String userId, final CreateUpdateUserRequest createUpdateUserRequest);

}
