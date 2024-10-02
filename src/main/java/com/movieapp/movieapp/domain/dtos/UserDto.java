package com.movieapp.movieapp.domain.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    /**
     * ID of this user
     */
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
    private String email;

    /**
     * Avatar URL (profile pic)
     */
    private String avatarUrl;

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
     * Date last logged in
     */
    private LocalDateTime lastLoggedInOn;

}
