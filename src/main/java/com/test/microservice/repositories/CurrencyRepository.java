package com.test.microservice.repositories;

import com.test.microservice.entities.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {
}
