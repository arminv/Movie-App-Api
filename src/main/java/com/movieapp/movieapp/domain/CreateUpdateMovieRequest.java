package com.movieapp.movieapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateMovieRequest {

    private String movieDBId;

    private String name;

    private String userId;

    private float rating;

    private String review;

}
