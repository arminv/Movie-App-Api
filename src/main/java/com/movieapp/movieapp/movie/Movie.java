package com.movieapp.movieapp.movie;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import com.movieapp.movieapp.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * A movie saved by a {@link User}.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@CompoundIndex(name = "unique_userId_movieDBId_name_idx", def = "{'userId' : 1, 'movieDBId' : 1, 'name': 1}", unique = true)
public class Movie {

    /**
     * ID of this movie
     */
    @Id
    private String id;

    /**
     * ID of this movie in Movie DB (external)
     */
    @NonNull
    private String movieDBId;

    /**
     * Name of this movie
     */
    private String name;

    /**
     * ID of {@link User} who saved this movie
     */
    @NonNull
    @CreatedBy
    private String userId;

    /**
     * Date created
     */
    @NonNull
    @CreatedDate
    private LocalDateTime created;

    /**
     * Date last updated
     */
    @NonNull
    @LastModifiedDate
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
