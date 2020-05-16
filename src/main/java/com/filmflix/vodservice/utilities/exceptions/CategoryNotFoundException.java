package com.filmflix.vodservice.utilities.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Integer categoryId) {
        super(String.format("Category with id %s not found", categoryId));
    }
}
