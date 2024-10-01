package com.movieapp.movieapp.domain.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

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
