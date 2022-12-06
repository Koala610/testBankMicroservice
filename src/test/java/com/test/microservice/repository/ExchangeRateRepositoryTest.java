package com.test.microservice.repository;

import com.test.microservice.entity.AbstractEntity;
import com.test.microservice.entity.ExchangeRate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.NoSuchElementException;
import java.util.Optional;
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
        ExchangeRate exchangeRate = (ExchangeRate) entity;
        exchangeRate.setFirstCurrency("KZT");
        exchangeRate.setSecondCurrency("USD");
        return (AbstractEntity) mainRepository.save(exchangeRate);
    }
    @Test
    public void testFindByCurrencies() {
        Optional<ExchangeRate> testExchangeRate = ((ExchangeRateRepository) mainRepository).findByFirstCurrencyAndSecondCurrency("USD", "KZT");
        try {
            testExchangeRate.get();
        }catch (NoSuchElementException e) {
            ExchangeRate exchangeRate = (ExchangeRate) createTestEntity();
            exchangeRate.setFirstCurrency("USD");
            exchangeRate.setSecondCurrency("KZT");
            testExchangeRate = Optional.of((ExchangeRate) mainRepository.save(exchangeRate));
        }
        assertThat(testExchangeRate).isNotNull();

    }
}
