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
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User mapFrom(final UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

}
