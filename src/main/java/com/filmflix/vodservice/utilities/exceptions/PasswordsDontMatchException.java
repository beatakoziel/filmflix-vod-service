package com.filmflix.vodservice.utilities.exceptions;

public class PasswordsDontMatchException extends RuntimeException {
    public PasswordsDontMatchException() {
        super("Password and repeat password don't match");
    }
}
