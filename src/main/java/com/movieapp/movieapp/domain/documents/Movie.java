package com.movieapp.movieapp.domain.documents;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String movieDBId;

    /**
     * Name of this movie
     */
    private String name;

    /**
     * ID of {@link User} who saved this movie
     */
    private String userId;

    /**
     * Date created
     */
    private LocalDateTime created;

    /**
     * Date last updated
     */
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
