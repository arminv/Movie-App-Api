package com.movieapp.movieapp.domain.documents;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
    @NonNull
    private String name;

    /**
     * Email for this user
     */
    @NonNull
    @Indexed(unique = true)
    private String email;

    /**
     * Avatar URL (profile pic)
     */
    private String avatarUrl;

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
     * Date last logged in
     */
    private LocalDateTime lastLoggedInOn;

}
