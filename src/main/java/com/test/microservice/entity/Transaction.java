package com.test.microservice.entity;

import io.swagger.annotations.ApiModel;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
@ApiModel("Transaction model")
public class Transaction extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long account_from;
    private Long account_to;
    private double sum;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expense_category_id")
    private ExpenseCategory expenseCategory;
    private boolean limitExceeded;

    public Transaction() {

    }
    public Transaction(Long account_from, Long account_to) {
        setAccount_from(account_from);
        setAccount_to(account_to);
    }
    public Transaction(Long account_from, Long account_to, ExpenseCategory expenseCategory) {
        this(account_from, account_to);
        setExpenseCategory(expenseCategory);
    }
    public Transaction(Long account_from, Long account_to, ExpenseCategory expenseCategory, Date datetime) {
        this(account_from, account_to, expenseCategory);
        setDatetime(datetime);
    }
    public Transaction(Long account_from, Long account_to, ExpenseCategory expenseCategory, Date datetime, double sum) {
        this(account_from, account_to, expenseCategory, datetime);
        setSum(sum);
    }


    public boolean isLimitExceeded() {
        return limitExceeded;
    }

    public void setLimitExceeded(boolean limitExceeded) {
        this.limitExceeded = limitExceeded;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Long getAccount_to() {
        return account_to;
    }

    public void setAccount_to(Long account_to) {
        this.account_to = account_to;
    }

    public Long getAccount_from() {
        return account_from;
    }

    public void setAccount_from(Long account_from) {
        this.account_from = account_from;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }
}
