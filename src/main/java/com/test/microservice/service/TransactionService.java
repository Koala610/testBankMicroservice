package com.test.microservice.service;

import com.test.microservice.entity.Transaction;
import com.test.microservice.repository.LimitRepository;
import com.test.microservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private LimitRepository limitRepository;
    public boolean checkIfTransactionLimitExceeded(Transaction transaction) {
        boolean result = false;
        return result;
    }
}
