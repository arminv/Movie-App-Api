package com.movieapp.movieapp.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.movieapp.movieapp.domain.CreateUpdateMovieRequest;
import com.movieapp.movieapp.domain.dtos.CreateUpdateMovieRequestDto;
import com.movieapp.movieapp.mappers.Mapper;

@Component
public class MovieCreateUpdateRequestMapper implements Mapper<CreateUpdateMovieRequest, CreateUpdateMovieRequestDto> {

    private final ModelMapper modelMapper;

    MovieCreateUpdateRequestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CreateUpdateMovieRequestDto mapTo(final CreateUpdateMovieRequest createUpdateMovieRequest) {
        return modelMapper.map(createUpdateMovieRequest, CreateUpdateMovieRequestDto.class);
    }

    @Override
    public CreateUpdateMovieRequest mapFrom(final CreateUpdateMovieRequestDto createUpdateMovieRequestDto) {
        return modelMapper.map(createUpdateMovieRequestDto, CreateUpdateMovieRequest.class);
    }

}
