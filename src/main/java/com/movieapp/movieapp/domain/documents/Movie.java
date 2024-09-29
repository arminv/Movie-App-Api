package com.movieapp.movieapp.domain.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * A movie saved by a {@link User}.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Movie {

    /**
     * ID of this movie
     */
    @Id
    private String id;

    private String movieDBId;

    /**
     * Name of this movie
     */
    private String name;

    /**
     * ID of user who saved this movie
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

}
