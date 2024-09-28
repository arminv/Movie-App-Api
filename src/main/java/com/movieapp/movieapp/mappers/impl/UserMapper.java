package com.movieapp.movieapp.mappers.impl;

import org.springframework.stereotype.Component;

import com.movieapp.movieapp.domain.documents.User;
import com.movieapp.movieapp.domain.dtos.UserDto;
import com.movieapp.movieapp.mappers.Mapper;

@Component
public class UserMapper implements Mapper<User, UserDto> {

    @Override
    public UserDto mapTo(User user) {
        return UserDto.builder()
            .id(user.getId())
            .name(user.getName())
            .email(user.getEmail())
            .created(user.getCreated())
            .lastUpdated(user.getLastUpdated())
            .build();
    }

    @Override
    public User mapFrom(UserDto userDto) {
        return User.builder()
            .id(userDto.getId())
            .name(userDto.getName())
            .email(userDto.getEmail())
            .created(userDto.getCreated())
            .lastUpdated(userDto.getLastUpdated())
            .build();
    }

}
