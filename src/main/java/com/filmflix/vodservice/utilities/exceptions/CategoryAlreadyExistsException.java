package com.filmflix.vodservice.utilities.exceptions;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String name) {
        super(String.format("Category %s already exists", name));
    }
}
