package com.test.microservice.service.exchangeRates;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExchangeRatesResponse {
    @JsonProperty("values")
    public List<ExchangeRateInformation> values;
    @JsonProperty("status")
    public String status;
}
