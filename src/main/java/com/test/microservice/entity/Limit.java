package com.test.microservice.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "limits")
public class Limit extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;
    private double limitSum;

    @Column(name = "remaining_sum")
    private double remainingSum;
    @Column(name = "limit_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date limitDatetime;

    @Enumerated(EnumType.STRING)
    private ExpenseCategory expenseCategory;
    @Column(name = "limit_currency_shortname")
    private String limitCurrencyShortname;
    @OneToMany(mappedBy = "limit", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Transaction> transactionList;

    public Limit() {
        setLimitCurrencyShortname("USD");
    }
    public Limit( Long accountId) {
        this();
        setAccountId(accountId);
    }

    public Limit(Long accountId, ExpenseCategory expenseCategory) {
        this(accountId);
        setExpenseCategory(expenseCategory);
    }
    public Limit(Long accountId, ExpenseCategory expenseCategory, double limitSum) {
        this(accountId, expenseCategory);
        setLimitSum(limitSum);
    }

    public Limit(Long accountId, ExpenseCategory expenseCategory, double limitSum, Date limitDatetime) {
        this(accountId, expenseCategory, limitSum);
        setLimitDatetime(limitDatetime);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getRemainingSum() {
        return remainingSum;
    }

    public void setRemainingSum(double convertedLimit, double transactionSum, double exchangeRate) {
        this.remainingSum = convertedLimit - transactionSum / exchangeRate;
    }
    public void setRemainingSum(double remainingSum) {
        this.remainingSum = remainingSum;
    }

    public String getLimitCurrencyShortname() {
        return limitCurrencyShortname;
    }

    public void setLimitCurrencyShortname(String limitCurrencyShortname) {
        this.limitCurrencyShortname = limitCurrencyShortname;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
