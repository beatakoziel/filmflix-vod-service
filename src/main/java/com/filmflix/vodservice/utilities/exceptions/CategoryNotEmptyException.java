package com.filmflix.vodservice.utilities.exceptions;

public class CategoryNotEmptyException extends RuntimeException {
    public CategoryNotEmptyException() {
        super("There are resources with this category");
    }
}
