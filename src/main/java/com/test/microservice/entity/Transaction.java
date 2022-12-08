package com.test.microservice.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_from")
    private Long accountFrom;
    @Column(name = "account_to")
    private Long accountTo;
    private double sum;
    @Column(name = "datetime")
    @DateTimeFormat(pattern = "dd/MM/yy hh:mm:ss")
    private Date datetime;
    @Column(name = "expense_category")
    @Enumerated(EnumType.STRING)
    private ExpenseCategory expenseCategory;
    @Column(name = "currency_shortname")
    private String currencyShortName;
    private boolean limitExceeded;

    public Transaction() {
        setCurrencyShortName("KZT");
    }
    public Transaction(Long accountFrom, Long accountTo) {
        this();
        setAccountFrom(accountFrom);
        setAccountTo(accountTo);
    }
    public Transaction(Long accountFrom, Long accountTo, ExpenseCategory expenseCategory) {
        this(accountFrom, accountTo);
        setExpenseCategory(expenseCategory);
    }
    public Transaction(Long accountFrom, Long accountTo, ExpenseCategory expenseCategory, Date datetime) {
        this(accountFrom, accountTo, expenseCategory);
        setDatetime(datetime);
    }
    public Transaction(Long accountFrom, Long accountTo, ExpenseCategory expenseCategory, Date datetime, double sum) {
        this(accountFrom, accountTo, expenseCategory, datetime);
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

    public Long getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Long accountTo) {
        this.accountTo = accountTo;
    }

    public Long getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Long accountFrom) {
        this.accountFrom = accountFrom;
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

    public String getCurrencyShortName() {
        return currencyShortName;
    }

    public void setCurrencyShortName(String currencyShortName) {
        this.currencyShortName = currencyShortName;
    }
}
