package com.test.microservice.entity;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Date;

@Table(value = "exchange_rates")
public class ExchangeRate extends AbstractEntity{
    @PrimaryKey
    @Column(value = "id")
    private Long id;
    @Column(value = "first_currency")
    private BigDecimal firstCurrency;
    @Column(value = "second_currency")
    private BigDecimal secondCurrency;
    @Column(value = "update_date")
    private Date updateDate;
    public ExchangeRate() {

    }


    public BigDecimal getFirstCurrency() {
        return firstCurrency;
    }

    public void setFirstCurrency(BigDecimal firstCurrency) {
        this.firstCurrency = firstCurrency;
    }

    public BigDecimal getSecondCurrency() {
        return secondCurrency;
    }

    public void setSecondCurrency(BigDecimal secondCurrency) {
        this.secondCurrency = secondCurrency;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
