package com.test.microservice.controller;

import com.test.microservice.entity.AbstractEntity;
import com.test.microservice.entity.Limit;
import com.test.microservice.entity.Transaction;
import com.test.microservice.entity.request.LimitRequest;
import com.test.microservice.entity.Response;
import com.test.microservice.entity.request.TransactionRequest;
import com.test.microservice.service.LimitService;
import com.test.microservice.service.TransactionService;
import javax.validation.Valid;

import com.test.microservice.service.exchangeRates.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class LimitController {
    @Autowired
    private LimitService limitService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ExchangeRatesService exchangeRatesService;
    @PostMapping("/limits/")
    public Response getLimits(@RequestBody @Valid LimitRequest limitRequest) {
        double exchangeRate = exchangeRatesService.getExchangeRateDouble();
        Optional<Limit> preLimit = limitService.getLimit(limitRequest.getAccountId(), limitRequest.getExpenseCategory());
        Limit newLimit;
        newLimit = new Limit(limitRequest.getAccountId(), limitRequest.getExpenseCategory(), limitRequest.getLimitSum());
        newLimit.setRemainingSum(limitRequest.getLimitSum() * exchangeRate);
        limitService.createLimit(newLimit);
        return new Response("OK", limitRequest);
    }
    @GetMapping("/transactions")
    public Response getLimitExceededTransactions(@RequestParam(name = "accountId") Long accountId) {
        List<Transaction> transactions = transactionService.getLimitExceededTransactions(accountId);
        AbstractEntity[] body = new AbstractEntity[transactions.size()];
        int cnt = 0;
        for(Transaction transaction : transactions) {
            body[cnt] = new TransactionRequest(transaction);
            cnt++;
        }
        return new Response("OK", body);
    }
}
