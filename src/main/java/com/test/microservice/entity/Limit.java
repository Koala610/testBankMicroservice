package com.test.microservice.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "limits")
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

    public Limit() {
    }
    public Limit(Long accountId) {
        setAccountId(accountId);
    }
    public Limit(Long accountId, double limitSum) {
        this(accountId);
        setLimitSum(limitSum);
    }

    public Limit(Long accountId, ExpenseCategory expenseCategory) {
        this(accountId);
        setExpenseCategory(expenseCategory);
    }
    public Limit(Long accountId, double limitSum, ExpenseCategory expenseCategory) {
        this(accountId, limitSum);
        setExpenseCategory(expenseCategory);
    }

    public Limit(Long accountId, ExpenseCategory expenseCategory, double limitSum) {
        this(accountId, expenseCategory);
        setLimitSum(limitSum);
    }

    public Limit(Long accountId, double limitSum, ExpenseCategory expenseCategory, Date limitDatetime) {
        this(accountId, limitSum, expenseCategory);
        setLimitDatetime(limitDatetime);
    }

    public Limit(Long accountId, ExpenseCategory expenseCategory, double limitSum, Date limitDatetime) {
        this(accountId, expenseCategory, limitSum);
        setLimitDatetime(limitDatetime);
    }

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

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public Date getLimitDatetime() {
        return limitDatetime;
    }

    public void setLimitDatetime(Date limitDatetime) {
        this.limitDatetime = limitDatetime;
    }
}
