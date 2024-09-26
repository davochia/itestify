package com.dattech.iTestify.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Integer id) {
        super("Could not find wiki category " + id);
    }
}
