package com.test.microservice.repository;

import com.test.microservice.entity.ExchangeRate;
import com.test.microservice.entity.Limit;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ExchangeRateRepository extends CassandraRepository<ExchangeRate, Integer> {
    @Query("select e from ExchangeRate e where e.firstCurrency = ?1 and e.secondCurrency=?2")
    @AllowFiltering
    Optional<ExchangeRate> findByFirstCurrencyAndSecondCurrency(String firstCurrency, String secondCurrency);
}
