package com.test.microservice.service;

import com.test.microservice.service.exchangeRates.ExchangeRateInformation;
import com.test.microservice.service.exchangeRates.ExchangeRatesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class ExchangeRatesServiceTest {
    @Autowired
    private ExchangeRatesService service;

    @Test
    public void testObtainingInformation() {
       ExchangeRateInformation information = service.getExchangeRateInformation();
       System.out.println(information.close);
       assertThat(information).isNotNull();
    }
}
