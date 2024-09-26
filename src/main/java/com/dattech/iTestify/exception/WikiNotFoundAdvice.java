package com.dattech.iTestify.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WikiNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(WikiNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String wikiNotFoundHandler(WikiNotFoundException ex) {
        return ex.getMessage();
    }
}
