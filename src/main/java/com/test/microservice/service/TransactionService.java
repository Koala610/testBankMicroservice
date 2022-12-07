package com.test.microservice.service;

import com.test.microservice.entity.Limit;
import com.test.microservice.entity.Transaction;
import com.test.microservice.repository.LimitRepository;
import com.test.microservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private LimitService limitService;
    public boolean createTransaction(Transaction transaction) {
        Limit limit = limitService.getLimitForTransaction(transaction);
        if(limit.getRemainingSum() < 0) {
            transaction.setLimitExceeded(true);
        }
       transactionRepository.save(transaction);
       return true;
    }

    public List<Transaction> getAllTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }
}
