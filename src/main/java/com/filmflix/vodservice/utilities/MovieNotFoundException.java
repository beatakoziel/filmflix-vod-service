package com.filmflix.vodservice.utilities;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long movieId) {
        super(String.format("Movie with id %s not found", movieId));
    }
}
