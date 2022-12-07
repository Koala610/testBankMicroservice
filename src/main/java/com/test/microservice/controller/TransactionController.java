package com.test.microservice.controller;

import com.test.microservice.entity.Transaction;
import com.test.microservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService service;
    @PostMapping("/")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        service.createTransaction(transaction);
        return  transaction;
    }

    @GetMapping("")
    public List<Transaction> getTransactions() {
        return service.getAllTransactions();
    }
}
