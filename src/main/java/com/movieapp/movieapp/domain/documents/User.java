package com.movieapp.movieapp.domain.documents;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document
public class User {

    /**
     * ID of this user
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
    @Indexed(unique = true)
    private String email;

    /**
     * Avatar URL (profile pic)
     */
    private String avatarUrl;

    /**
     * Date created
     */
    private LocalDateTime created;

    /**
     * Date last updated
     */
    private LocalDateTime lastUpdated;

    /**
     * Date last logged in
     */
    private LocalDateTime lastLoggedInOn;

}
