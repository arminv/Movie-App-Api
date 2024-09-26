package com.movieapp.movieapp.domain.documents;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A user in the system.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    /**
     * ID of this movie
     */
    @Id
    private String id;

    /**
     * Name of the user
     */
    private String name;

    /**
     * Email for this user
     */
    private String email;

    /**
     * Date created
     */
    private LocalDateTime created;

    /**
     * Date last updated
     */
    private LocalDateTime lastUpdated;

}
