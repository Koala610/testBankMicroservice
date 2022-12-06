package com.test.microservice.repository;

import com.test.microservice.entity.AbstractEntity;
import com.test.microservice.entity.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Random;

@SpringBootTest
public class ExchangeRateRepositoryTest extends CrudRepositoryTest{

    @Autowired
    public ExchangeRateRepositoryTest(ExchangeRateRepository mainRepository) {
        super(mainRepository);
    }

    @Override
    public AbstractEntity createTestEntity() {
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setId(new Random().nextLong());
        return (AbstractEntity) mainRepository.save(exchangeRate);
    }

    @Override
    public void deleteTestEntity(AbstractEntity entity) {
        ExchangeRate exchangeRate = (ExchangeRate) entity;
        mainRepository.delete(exchangeRate);
    }

    @Override
    public AbstractEntity updateTestEntity(AbstractEntity entity) {
        ExchangeRate exchangeRate = (ExchangeRate) createTestEntity();
        exchangeRate.setFirstCurrency(BigDecimal.valueOf(1111));
        exchangeRate.setSecondCurrency(BigDecimal.valueOf(2222));
        return (AbstractEntity) mainRepository.save(exchangeRate);
    }
}
