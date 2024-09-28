package com.movieapp.movieapp.services;

import java.util.Optional;

import com.movieapp.movieapp.domain.CreateUpdateUserRequest;
import com.movieapp.movieapp.domain.documents.User;

public interface UserService {

    Optional<User> getUserById(String userId);

    User createUpdateUser(final String userId, final CreateUpdateUserRequest createUpdateUserRequest);

    void deleteUser(String userId);

}
