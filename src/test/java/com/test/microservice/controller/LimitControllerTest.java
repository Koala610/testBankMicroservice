package com.test.microservice.controller;

import com.test.microservice.entity.AbstractEntity;
import com.test.microservice.entity.Response;
import com.test.microservice.entity.request.TransactionRequest;
import com.test.microservice.repository.LimitRepository;
import com.test.microservice.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LimitControllerTest {
    @Autowired
    private LimitController limitController;
    @Autowired
    private TransactionRepository transactionRepository;
    @Test
    public void testObtainingTransactions() {
        int length = transactionRepository.findByAccountIdAndLimitExceeded(1111L, true).size();
        Response response = limitController.getLimitExceededTransactions(1111L);
        AbstractEntity[] transactionRequest = response.getBody();
        assertEquals(length, transactionRequest.length);
    }

}
