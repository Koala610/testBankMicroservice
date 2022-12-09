package com.test.microservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private String status;
    private String[] messages;
    private AbstractEntity body;
    public Response(String status) {
       setStatus(status);
    }

    public Response(String status, String[] messages) {
        this(status);
        setMessages(messages);
    }
    public Response(String status, AbstractEntity body) {
        this(status);
        setBody(body);
    }
    public Response(String status, String[] messages, AbstractEntity body) {
        this(status, messages);
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

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;

    }
}
