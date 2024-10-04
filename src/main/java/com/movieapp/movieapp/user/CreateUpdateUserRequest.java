package com.movieapp.movieapp.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateUserRequest {

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

}
