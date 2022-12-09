package com.test.microservice.entity.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.microservice.entity.AbstractEntity;
import com.test.microservice.entity.ExpenseCategory;
import com.test.microservice.entity.Limit;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LimitRequest extends AbstractEntity {
    @NotNull
    private Long accountId;
    @Min(1)
    @NotNull
    private double limitSum;
    @NotNull
    private ExpenseCategory expenseCategory;
    private Date limitDatetime;
    private String currencyShortname;
    public LimitRequest(Limit limit) {
        setLimitSum(limit.getLimitSum());
        setLimitDatetime(limit.getLimitDatetime());
        setCurrencyShortname(limit.getLimitCurrencyShortname());

    }

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

    public Date getLimitDatetime() {
        return limitDatetime;
    }

    public void setLimitDatetime(Date limitDatetime) {
        this.limitDatetime = limitDatetime;
    }

    public String getCurrencyShortname() {
        return currencyShortname;
    }

    public void setCurrencyShortname(String currencyShortname) {
        this.currencyShortname = currencyShortname;
    }
}
