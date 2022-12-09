package com.test.microservice.service;
import com.test.microservice.entity.ExpenseCategory;
import com.test.microservice.entity.Limit;
import com.test.microservice.entity.Transaction;
import com.test.microservice.entity.request.TransactionRequest;
import com.test.microservice.repository.TransactionRepository;
import com.test.microservice.service.exchangeRates.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private ExchangeRatesService exchangeRatesService;
    @Autowired
    private LimitService limitService;
    public Optional<Transaction> createTransaction(Transaction transaction) {
        transaction = getTransactionWithLimit(transaction);
        if(transaction.getLimit().getRemainingSum() < 0) {
            transaction.setLimitExceeded(true);
        }
       Transaction resultTransaction = transactionRepository.save(transaction);
       return Optional.of(resultTransaction);
    }
    public Optional<Transaction> createTransactionFromRequest(TransactionRequest request) {
        return  createTransaction(request.toTransaction());
    }
    public Transaction getTransactionWithLimit(Transaction transaction) {
        Long account_from = transaction.getAccountFrom();
        ExpenseCategory category = transaction.getExpenseCategory();
        double sum = transaction.getSum();
        Optional<Limit> preLimit = limitService.getLimit(account_from, category);
        double exchangeRate = exchangeRatesService.getExchangeRateDouble();
        if(preLimit.isEmpty()) {
            Limit limit = new Limit(account_from, category, 0);
            limit.setRemainingSum(0, sum, exchangeRate);
            limit = limitService.createLimit(limit);
            transaction.setLimit(limit);
            return transaction;
        }
        Limit limit = preLimit.get();
        double convertedLimit =  exchangeRate * limit.getRemainingSum();
        limit.setRemainingSum(convertedLimit ,sum, exchangeRate);
        transaction.setLimit(limit);
        return transaction;
    }

    public List<Transaction> getAllTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    public List<Transaction> getLimitExceededTransactions(Long accountId) {
        return transactionRepository.findByAccountIdAndLimitExceeded(accountId, true);
    }
}
