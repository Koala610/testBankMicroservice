package com.test.microservice.exceptions;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler
    public Error handlerHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Error error = new Error();
        error.setStatus("error");
        error.setMessage(ex.getMessage());
        return error;
    }
}
