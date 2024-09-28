package com.movieapp.movieapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateUserRequest {

    /**
     * Name of the user
     */
    private String name;

    /**
     * Email for this user
     */
    private String email;

}
