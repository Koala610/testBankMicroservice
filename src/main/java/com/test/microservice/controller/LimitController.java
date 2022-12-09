package com.test.microservice.controller;

import com.test.microservice.entity.Limit;
import com.test.microservice.entity.request.LimitRequest;
import com.test.microservice.entity.Response;
import com.test.microservice.service.LimitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/limits")
public class LimitController {
    @Autowired
    private LimitService limitService;
    @PostMapping("/")
    public Response getLimits(@RequestBody @Valid LimitRequest limitRequest) {
        Optional<Limit> preLimit = limitService.getLimit(limitRequest.getAccountId(), limitRequest.getExpenseCategory());
        Limit newLimit;
        newLimit = new Limit(limitRequest.getAccountId(), limitRequest.getExpenseCategory(), limitRequest.getLimitSum());
        if(preLimit.isPresent()) {
            newLimit= preLimit.get();
            newLimit.setLimitSum(limitRequest.getLimitSum());
        }
        newLimit.setRemainingSum(limitRequest.getLimitSum());
        limitService.createLimit(newLimit);
        return new Response("OK", limitRequest);
    }
}
