package com.test.microservice.service.exchangeRates;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ExchangeRateInformation {
    @JsonProperty("datetime")
    public Date datetime;
    @JsonProperty("open")
    public BigDecimal open;
    @JsonProperty("high")
    public BigDecimal high;
    @JsonProperty("low")
    public BigDecimal low;
    @JsonProperty("close")
    public BigDecimal close;
}
