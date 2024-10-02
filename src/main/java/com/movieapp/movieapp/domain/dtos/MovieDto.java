package com.movieapp.movieapp.domain.dtos;

import java.time.LocalDateTime;

import com.movieapp.movieapp.domain.documents.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDto {

    private String id;

    /**
     * ID of this movie in Movie DB (external)
     */
    @NonNull
    private String movieDBId;

    private String name;

    /**
     * ID of {@link User} who saved this movie
     */
    @NonNull
    private String userId;

    /**
     * Date created
     */
    @NonNull
    private LocalDateTime created;

    /**
     * Date last updated
     */
    @NonNull
    private LocalDateTime lastUpdated;

    /**
     * Rating given to movie by user
     */
    private float rating;

    /**
     * Review given to movie by user
     */
    private String review;

}
