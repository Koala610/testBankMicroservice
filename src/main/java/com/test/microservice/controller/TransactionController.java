package com.test.microservice.controller;

import com.test.microservice.entity.Transaction;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @PostMapping("/")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        System.out.println(transaction.getId());
        return  transaction;
    }
}
