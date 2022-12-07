package com.test.microservice.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "limits")
public class Limit extends AbstractEntity {
    @Id
    private Long id;

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
    public Limit(Long Id) {
        setId(Id);
    }
    public Limit(Long Id, Long accountId) {
        this(Id);
        setAccountId(accountId);
    }

    public Limit(Long Id, Long accountId, ExpenseCategory expenseCategory) {
        this(Id, accountId);
        setExpenseCategory(expenseCategory);
    }
    public Limit(Long Id, Long accountId, ExpenseCategory expenseCategory, double limitSum) {
        this(Id, accountId, expenseCategory);
        setLimitSum(limitSum);
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
}
