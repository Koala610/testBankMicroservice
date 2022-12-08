package com.test.microservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LimitRequest extends AbstractEntity {
    private Long accountId;
    private double limitSum;
    private ExpenseCategory expenseCategory;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public double getLimitSum() {
        return limitSum;
    }

    public void setLimitSum(double limitSum) {
        this.limitSum = limitSum;
    }
}
