package com.test.microservice.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "limits")
public class Limit extends AbstractEntity {
    @Id
    private Long id;
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
    public Limit(Long Id, double limitSum) {
        this(Id);
        setLimitSum(limitSum);
    }

    public Limit(Long Id, ExpenseCategory expenseCategory) {
        this(Id);
        setExpenseCategory(expenseCategory);
    }
    public Limit(Long Id, double limitSum, ExpenseCategory expenseCategory) {
        this(Id, limitSum);
        setExpenseCategory(expenseCategory);
    }

    public Limit(Long Id, ExpenseCategory expenseCategory, double limitSum) {
        this(Id, expenseCategory);
        setLimitSum(limitSum);
    }

    public Limit(Long Id, double limitSum, ExpenseCategory expenseCategory, Date limitDatetime) {
        this(Id, limitSum, expenseCategory);
        setLimitDatetime(limitDatetime);
    }

    public Limit(Long Id, ExpenseCategory expenseCategory, double limitSum, Date limitDatetime) {
        this(Id, expenseCategory, limitSum);
        setLimitDatetime(limitDatetime);
    }

    @Override
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
}
