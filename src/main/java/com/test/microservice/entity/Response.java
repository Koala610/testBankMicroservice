package com.test.microservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private String status;
    private String message;
    private AbstractEntity body;
    public Response(String status) {
       setStatus(status);
    }

    public Response(String status, String message) {
        this(status);
        setMessage(message);
    }
    public Response(String status, AbstractEntity body) {
        this(status);
        setBody(body);
    }
    public Response(String status, String message, AbstractEntity body) {
        this(status, message);
        setBody(body);
    }
    public Response() {

    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AbstractEntity getBody() {
        return body;
    }

    public void setBody(AbstractEntity body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
