package com.test.microservice.controller;

import com.test.microservice.entity.ExpenseCategory;
import com.test.microservice.entity.Limit;
import com.test.microservice.entity.Response;
import com.test.microservice.repository.LimitRepository;
import com.test.microservice.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.test.microservice.entity.Transaction;

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
        Transaction transaction = new Transaction();
        Response response;
        response = transactionController.createTransaction(transaction);
        System.out.println(response.getStatus() + " " + response.getMessage() + " " + response.getBody());
        assertEquals(response.getStatus(), "error");
    }
    @Test
    public void canAcceptUsualObject() {
        Transaction transaction = new Transaction(99999L, 88888L, ExpenseCategory.product, new Date(System.currentTimeMillis()), 33.33);
        Response response = transactionController.createTransaction(transaction);
        transaction = (Transaction) response.getBody();
        assertEquals(response.getStatus(), "OK");
        assertEquals(transaction.getCurrencyShortName(), "KZT");
        Optional<Limit> limit = limitRepository.findByAccountIdAndExpenseCategory(99999L, ExpenseCategory.product);
        assertThat(limit).isNotNull();
        limitRepository.delete(limit.get());
        transactionRepository.delete(transaction);
    }
}
