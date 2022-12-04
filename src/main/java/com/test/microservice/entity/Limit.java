package com.test.microservice.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Limit {
    @Id
    private Long accountId;
    private double limitSum;
    @Column(name = "limit_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date limitDatetime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expense_category_id")
    private ExpenseCategory expenseCategory;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getLimitSum() {
        return limitSum;
    }

    public void setLimitSum(double limitSum) {
        this.limitSum = limitSum;
    }
}
