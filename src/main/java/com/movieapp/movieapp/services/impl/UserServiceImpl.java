package com.movieapp.movieapp.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movieapp.movieapp.domain.documents.User;
import com.movieapp.movieapp.repositories.UserRepository;
import com.movieapp.movieapp.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

}
