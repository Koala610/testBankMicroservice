package com.test.microservice.exceptions;

import com.test.microservice.entity.Response;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler
    public Response handlerHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Response response = new Response();
        response.setStatus("error");
        response.setMessage(ex.getMessage());
        return response;
    }
}
