package com.movieapp.movieapp.exceptions;

public class MovieappApplication extends RuntimeException {

    public MovieappApplication() {
    }

    public MovieappApplication(String message) {
        super(message);
    }

    public MovieappApplication(String message, Throwable cause) {
        super(message, cause);
    }

}
