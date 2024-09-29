package com.movieapp.movieapp.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateMovieRequestDto {

    private String movieDBId;

    private String name;

    private String userId;

}
