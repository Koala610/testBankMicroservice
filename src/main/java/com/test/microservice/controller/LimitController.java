package com.test.microservice.controller;

import com.test.microservice.entity.Limit;
import com.test.microservice.entity.LimitRequest;
import com.test.microservice.entity.Response;
import com.test.microservice.repository.LimitRepository;
import com.test.microservice.service.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/limits")
public class LimitController {
    @Autowired
    private LimitService limitService;
    @PostMapping("/")
    public Response getLimits(@RequestBody LimitRequest limitRequest) {
        if(limitRequest.getAccountId() == null) {
           return new Response("error", "accountId is required field");
        }
        if(limitRequest.getLimitSum() <= 0) {
            return new Response("error", "limitSum should be positive");
        }
        Optional<Limit> preLimit = limitService.getLimit(limitRequest.getAccountId(), limitRequest.getExpenseCategory());
        Limit newLimit;
        newLimit = new Limit(limitRequest.getAccountId(), limitRequest.getExpenseCategory(), limitRequest.getLimitSum());
        if(preLimit.isPresent()) {
            newLimit= preLimit.get();
            newLimit.setLimitSum(limitRequest.getLimitSum());
        }
        newLimit.setRemainingSum(newLimit.getLimitSum());
        limitService.createLimit(newLimit);
        return new Response("OK", limitRequest);
    }
}
