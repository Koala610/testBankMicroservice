package com.test.microservice.service;

import com.test.microservice.entity.ExpenseCategory;
import com.test.microservice.entity.Limit;
import com.test.microservice.entity.Transaction;
import com.test.microservice.repository.LimitRepository;
import com.test.microservice.service.exchangeRates.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class LimitService {
    @Autowired
    private LimitRepository limitRepository;
    @Autowired
    private ExchangeRatesService exchangeRatesService;

    public Limit getLimitForTransaction(Transaction transaction) {
        Long account_from = transaction.getAccountFrom();
        ExpenseCategory category = transaction.getExpenseCategory();
        Date currentDatetime = new Date(System.currentTimeMillis());
        double sum = transaction.getSum();
        Optional<Limit> preLimit = limitRepository.findByAccountIdAndExpenseCategory(account_from, category);
        double exchangeRate = exchangeRatesService.getExchangeRateInformation().close.doubleValue();
        if(preLimit.isEmpty()) {
            Limit limit = new Limit(account_from, category, 0, currentDatetime);
            limit.setRemainingSum(0, sum, exchangeRate);
            return limitRepository.save(limit);
        }
        Limit limit = preLimit.get();
        double convertedLimit =  exchangeRate * limit.getRemainingSum();
        limit.setRemainingSum(convertedLimit ,sum, exchangeRate);
        return preLimit.get();
    }

    public Limit createLimit(Limit limit) {
        return limitRepository.save(limit);
    }

}
