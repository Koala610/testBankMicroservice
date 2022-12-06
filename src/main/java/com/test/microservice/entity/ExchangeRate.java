package com.test.microservice.entity;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Table(value = "exchange_rates")
public class ExchangeRate extends AbstractEntity{
    @PrimaryKey
    @Column(value = "id")
    private Long id;
    @Column(value = "first_currency")
    private String firstCurrency;
    @Column(value = "second_currency")
    private String secondCurrency;

    @Column(value = "value")
    private BigDecimal value;
    @Column(value = "timestamp")
    private Date timestamp;
    public ExchangeRate() {

    }


    public String getFirstCurrency() {
        return firstCurrency;
    }

    public void setFirstCurrency(String firstCurrency) {
        this.firstCurrency = firstCurrency;
    }

    public String getSecondCurrency() {
        return secondCurrency;
    }

    public void setSecondCurrency(String secondCurrency) {
        this.secondCurrency = secondCurrency;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public Date convertDateByTimeZone(Instant datetime, String timezone) {
        ZoneId zoneId = ZoneId.of(timezone);
        return Date.from(ZonedDateTime.ofInstant(datetime, zoneId).toInstant());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
