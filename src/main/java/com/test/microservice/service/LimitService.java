package com.test.microservice.service;

import com.test.microservice.entity.ExpenseCategory;
import com.test.microservice.entity.Limit;
import com.test.microservice.repository.LimitRepository;
import com.test.microservice.repository.TransactionRepository;
import com.test.microservice.service.exchangeRates.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LimitService {
    @Autowired
    private LimitRepository limitRepository;
    @Autowired
    private ExchangeRatesService exchangeRatesService;
    @Autowired
    private TransactionRepository transactionRepository;



    public Limit createLimit(Limit limit) {
        limit.setLimitDatetime(new Date(System.currentTimeMillis()));
        return limitRepository.save(limit);
    }

    public List<Limit> getLimits() {
        return (List<Limit>) limitRepository.findAll();
    }
    public List<Limit> getLimits(Long account_id) {
        return limitRepository.findByAccountId(account_id);
    }
    public Optional<Limit> getLimit(Long account_id, ExpenseCategory expenseCategory) {
        return limitRepository.findByAccountIdAndExpenseCategory(account_id, expenseCategory);
    }

}
