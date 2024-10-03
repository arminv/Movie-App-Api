package com.movieapp.movieapp.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MovieappApplication extends RuntimeException {

    public MovieappApplication(String message) {
        super(message);
    }

    public MovieappApplication(String message, Throwable cause) {
        super(message, cause);
    }

}
