package com.test.microservice.controller;

import com.test.microservice.entity.Response;
import com.test.microservice.entity.Transaction;
import com.test.microservice.entity.request.TransactionRequest;
import com.test.microservice.service.TransactionService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private TransactionService transactionService;
    @PostMapping("/")
    public Response createTransaction(@RequestBody @Valid TransactionRequest transactionRequest) {
        Optional<Transaction> finalTransaction = null;
        try {
             finalTransaction = transactionService.createTransactionFromRequest(transactionRequest);
        }catch (DataIntegrityViolationException ex) {
            return new Response("error", new String[]{ex.getMessage()});
        }
        if(finalTransaction.isPresent()) {
            return new Response("OK", transactionRequest);
        }
        return  new Response("error", new String[]{"Can not save transaction..."});
    }

    @GetMapping("")
    public List<Transaction> getTransactions() {
        return transactionService.getAllTransactions();
    }

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
}
