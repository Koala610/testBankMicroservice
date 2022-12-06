package com.test.microservice.repository;

import com.test.microservice.entity.ExchangeRate;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;


public interface ExchangeRateRepository extends CassandraRepository<ExchangeRate, Integer> {
}
