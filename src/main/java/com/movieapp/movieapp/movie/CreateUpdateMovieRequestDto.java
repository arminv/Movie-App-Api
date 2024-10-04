package com.movieapp.movieapp.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateMovieRequestDto {

    @NonNull
    private String movieDBId;

    private String name;

    @NonNull
    private String userId;

    private float rating;

    private String review;

}
