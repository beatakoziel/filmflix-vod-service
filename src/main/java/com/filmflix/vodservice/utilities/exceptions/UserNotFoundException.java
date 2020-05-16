package com.filmflix.vodservice.utilities.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super(String.format("User with username %s not found", email));
    }
}
