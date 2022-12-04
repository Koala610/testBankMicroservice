package com.test.microservice.repository;

import com.test.microservice.entity.Limit;
import org.springframework.data.repository.CrudRepository;

public interface LimitRepository extends CrudRepository<Limit, Long> {
}
