package com.dattech.iTestify.exception;

public class WikiNotFoundException extends RuntimeException {
    public WikiNotFoundException(Integer id) {
        super("Could not find wiki " + id);
    }

}
