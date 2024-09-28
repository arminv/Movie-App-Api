package com.movieapp.movieapp.mappers.impl;

import org.springframework.stereotype.Component;

import com.movieapp.movieapp.domain.CreateUpdateUserRequest;
import com.movieapp.movieapp.domain.dtos.CreateUpdateUserRequestDto;
import com.movieapp.movieapp.mappers.Mapper;

@Component
public class UserCreateUpdateRequestMapper implements Mapper<CreateUpdateUserRequest, CreateUpdateUserRequestDto> {

    @Override
    public CreateUpdateUserRequestDto mapTo(final CreateUpdateUserRequest createUpdateUserRequest) {
        return CreateUpdateUserRequestDto.builder()
            .name(createUpdateUserRequest.getName())
            .email(createUpdateUserRequest.getEmail())
            .build();
    }

    @Override
    public CreateUpdateUserRequest mapFrom(final CreateUpdateUserRequestDto createUpdateUserRequestDto) {
        return CreateUpdateUserRequest.builder()
            .name(createUpdateUserRequestDto.getName())
            .email(createUpdateUserRequestDto.getEmail())
            .build();
    }

}
