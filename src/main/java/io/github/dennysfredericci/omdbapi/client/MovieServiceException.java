package io.github.dennysfredericci.omdbapi.client;

public class MovieServiceException extends RuntimeException {
    public MovieServiceException(String message) {
        super(message);
    }
}
