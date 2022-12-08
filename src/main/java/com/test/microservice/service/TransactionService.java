package com.test.microservice.service;

import com.test.microservice.entity.Limit;
import com.test.microservice.entity.Transaction;
import com.test.microservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private LimitService limitService;
    public Optional<Transaction> createTransaction(Transaction transaction) {
        Limit limit;
        limit = limitService.getLimitForTransaction(transaction);

        Transaction resultTransaction;
        if(limit.getRemainingSum() < 0) {
            transaction.setLimitExceeded(true);
        }
       resultTransaction = transactionRepository.save(transaction);
       return Optional.of(resultTransaction);
    }

    public List<Transaction> getAllTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }
}
