package com.test.microservice.service;

import com.test.microservice.entity.Transaction;
import com.test.microservice.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Test
    public void checkObtainingData() {
        int count = (int) transactionRepository.count();
        List<Transaction> transactionList = transactionService.getAllTransactions();
        assertEquals(transactionList.size(), count);
    }
}
