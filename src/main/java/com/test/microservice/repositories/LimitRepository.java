package com.test.microservice.repositories;

import com.test.microservice.entities.Limit;
import org.springframework.data.repository.CrudRepository;

public interface LimitRepository extends CrudRepository<Limit, Long> {
}
