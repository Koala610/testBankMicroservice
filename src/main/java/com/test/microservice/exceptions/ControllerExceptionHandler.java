package com.test.microservice.exceptions;

import com.test.microservice.entity.Response;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler
    public Response handlerHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Response response = new Response();
        response.setStatus("error");
        response.setMessages(new String[]{ex.getMessage()});
        return response;
    }
    @ExceptionHandler
    public Response handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        Response response = new Response();
        response.setStatus("error");
        response.setMessages(new String[]{ex.getMessage()});
        return response;
    }
    @ExceptionHandler
    public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Response response = new Response();
        String[] messages = new String[ex.getAllErrors().size()] ;
        response.setStatus("error");
        int cnt = 0;
        for(ObjectError objectError : ex.getAllErrors()) {
            FieldError fieldError = (FieldError)objectError;
             messages[cnt] = fieldError.getField() + " " + fieldError.getDefaultMessage();
             cnt++;
        }
        response.setMessages(messages);
        return response;
    }
}
