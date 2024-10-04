package com.movieapp.movieapp.user;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.movieapp.movieapp.mappers.Mapper;

@Component
public class UserCreateUpdateRequestMapper implements Mapper<CreateUpdateUserRequest, CreateUpdateUserRequestDto> {

    private final ModelMapper modelMapper;

    UserCreateUpdateRequestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CreateUpdateUserRequestDto mapTo(final CreateUpdateUserRequest createUpdateUserRequest) {
        return modelMapper.map(createUpdateUserRequest, CreateUpdateUserRequestDto.class);
    }

    @Override
    public CreateUpdateUserRequest mapFrom(final CreateUpdateUserRequestDto createUpdateUserRequestDto) {
        return modelMapper.map(createUpdateUserRequestDto, CreateUpdateUserRequest.class);
    }

}
