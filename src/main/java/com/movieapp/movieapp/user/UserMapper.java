package com.movieapp.movieapp.user;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.movieapp.movieapp.mappers.Mapper;

@Component
public class UserMapper implements Mapper<User, UserDto> {

    private final ModelMapper modelMapper;

    UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto mapTo(final User user) {
        if (user == null) {
            throw new NullPointerException("user is null");
        }

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User mapFrom(final UserDto userDto) {
        if (userDto == null) {
            throw new NullPointerException("userDto is null");
        }

        return modelMapper.map(userDto, User.class);
    }

}
