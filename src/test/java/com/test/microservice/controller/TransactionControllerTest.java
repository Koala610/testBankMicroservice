package com.test.microservice.controller;

import com.test.microservice.entity.*;
import com.test.microservice.repository.LimitRepository;
import com.test.microservice.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TransactionControllerTest {
    @Autowired
    private TransactionController transactionController;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private LimitRepository limitRepository;
    @Test
    public void canAcceptObjectWithNullFields() {

        TransactionRequest transactionRequest = new TransactionRequest();
        Response response;
        response = transactionController.createTransaction(transactionRequest);
        System.out.println(response.getStatus() + " " + response.getMessages() + " " + response.getBody());
        assertEquals(response.getStatus(), "error");
    }
    @Test
    public void canAcceptUsualObject() {
        TransactionRequest transactionRequest = new TransactionRequest(1111L, 2222L, ExpenseCategory.product);
        Response response = transactionController.createTransaction(transactionRequest);
        assertEquals(response.getStatus(), "OK");
    }
}
