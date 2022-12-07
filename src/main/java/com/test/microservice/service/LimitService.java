package com.test.microservice.service;

import com.test.microservice.entity.Limit;
import com.test.microservice.repository.LimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LimitService {
    @Autowired
    private LimitRepository limitRepository;

    public Limit createLimit(Limit limit) {
        limit.setLimitDatetime(new Date(System.currentTimeMillis()));
        return limitRepository.save(limit);
    }
}
