package com.test.microservice.projection;

import com.test.microservice.entity.ExpenseCategory;

import java.util.Date;

public interface TransactionWithoutLimitProjection {
    public Long getAccountFrom();
    public Long getAccountTo();
    public String getCurrencyShortName();
    public double getSum();
    public ExpenseCategory getExpenseCategory();
    public Date getDatetime();

}
