package com.test.microservice.service.exchangeRates;

import com.test.microservice.entity.ExchangeRate;
import com.test.microservice.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ExchangeRatesService {
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private ExchangeRateRepository repository;
    private final String apiUrl = "https://api.twelvedata.com/";
    @Value("${API_KEY}")
    private String token;

    public ExchangeRatesResponse getExchangeRatesResponse() {
        String url = getApiUrl() + "time_series?symbol=USD/KZT&interval=1day&apikey=" + token;
        ExchangeRatesResponse response = restTemplate.getForObject(url, ExchangeRatesResponse.class);
        return response;
    }

    public ExchangeRateInformation getExchangeRateInformation() {
        ExchangeRatesResponse response = getExchangeRatesResponse();
        return response.values.get(0);
    }
    public double getExchangeRateDouble() {
        return getExchangeRateInformation().close.doubleValue();
    }

    public boolean updateExchangeRates() {
        ExchangeRateInformation information = getExchangeRateInformation();
        Optional<ExchangeRate> preExchangeRate = repository.findByFirstCurrencyAndSecondCurrency("USD", "KZT");
        ExchangeRate exchangeRate;
        try {
            exchangeRate = preExchangeRate.get();
        }catch (NoSuchElementException e) {
            exchangeRate = new ExchangeRate();
            exchangeRate.setId(new Random().nextLong());
            exchangeRate.setSecondCurrency("KZT");
            exchangeRate.setFirstCurrency("USD");
        }
        exchangeRate.setValue(information.close);
        Date datetime = new Date(System.currentTimeMillis());
        exchangeRate.setTimestamp(datetime);
        repository.save(exchangeRate);
        return true;
    }
    public String getApiUrl() {
        return apiUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
