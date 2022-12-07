package com.test.microservice.service;

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
        Optional<Limit> preLimit = limitRepository.findByAccountIdAndExpenseCategory(transaction.getAccountFrom(), transaction.getExpenseCategory());
        double exchangeRate = exchangeRatesService.getExchangeRateInformation().close.doubleValue();
        if(preLimit.isEmpty()) {
            Limit limit = new Limit(transaction.getAccountFrom(), transaction.getExpenseCategory());
            limit.setLimitDatetime(new Date(System.currentTimeMillis()));
            limit.setLimitSum(0);
            limit.setRemainingSum(0 - (transaction.getSum() / exchangeRate));
            limit.setLimitCurrencyShortname("USD");
            return limitRepository.save(limit);
        }
        Limit limit = preLimit.get();
        double convertedLimit =  exchangeRate * limit.getRemainingSum();
        limit.setRemainingSum((convertedLimit - transaction.getSum() / exchangeRate));
        return preLimit.get();
    }

    public Limit createLimit(Limit limit) {
        return limitRepository.save(limit);
    }
}
