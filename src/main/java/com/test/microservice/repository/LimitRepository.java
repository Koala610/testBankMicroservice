package com.test.microservice.repository;

import com.test.microservice.entity.Limit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LimitRepository extends CrudRepository<Limit, Long> {
    @Query("select l from Limit l where l.limitSum= ?1")
    List<Limit> findByLimitSum(double limitSum);
}
