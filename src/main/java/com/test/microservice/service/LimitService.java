package com.test.microservice.service;

import com.test.microservice.repository.LimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LimitService {
    @Autowired
    private LimitRepository limitRepository;
}
