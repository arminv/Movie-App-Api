package com.movieapp.movieapp.movie;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.movieapp.movieapp.mappers.Mapper;

@Component
public class MovieCreateUpdateRequestMapper implements Mapper<CreateUpdateMovieRequest, CreateUpdateMovieRequestDto> {

    private final ModelMapper modelMapper;

    MovieCreateUpdateRequestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CreateUpdateMovieRequestDto mapTo(final CreateUpdateMovieRequest createUpdateMovieRequest) {
        if (createUpdateMovieRequest == null) {
            throw new NullPointerException("createUpdateMovieRequest is null");
        }

        return modelMapper.map(createUpdateMovieRequest, CreateUpdateMovieRequestDto.class);
    }

    @Override
    public CreateUpdateMovieRequest mapFrom(final CreateUpdateMovieRequestDto createUpdateMovieRequestDto) {
        if (createUpdateMovieRequestDto == null) {
            throw new NullPointerException("createUpdateMovieRequestDto is null");
        }

        return modelMapper.map(createUpdateMovieRequestDto, CreateUpdateMovieRequest.class);
    }

}
