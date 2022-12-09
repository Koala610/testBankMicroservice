package com.test.microservice.entity.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.microservice.entity.AbstractEntity;
import com.test.microservice.entity.ExpenseCategory;
import com.test.microservice.entity.Transaction;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionRequest extends AbstractEntity {
    @NotNull
    private Long accountFrom;
    @NotNull
    private Long accountTo;
    @NotNull
    @Min(1)
    private double sum;
    private Date datetime;
    @NotNull
    private ExpenseCategory expenseCategory;{};
    private String currencyShortname;
    private LimitRequest limit;

    public TransactionRequest() {

    }
    public TransactionRequest(Long accountFrom, Long accountTo) {
        setAccountFrom(accountFrom);
        setAccountTo(accountTo);
    }
    public TransactionRequest(Long accountFrom, Long accountTo, ExpenseCategory expenseCategory) {
        this(accountFrom, accountTo);
        setExpenseCategory(expenseCategory);
    }
    public TransactionRequest(Long accountFrom, Long accountTo, ExpenseCategory expenseCategory, Date datetime) {
        this(accountFrom, accountTo, expenseCategory);
        setDatetime(datetime);
    }
    public TransactionRequest(Long accountFrom, Long accountTo, ExpenseCategory expenseCategory, Date datetime, double sum) {
        this(accountFrom, accountTo, expenseCategory, datetime);
        setSum(sum);
    }
    public TransactionRequest(Transaction transaction) {
        setAccountFrom(transaction.getAccountFrom());
        setAccountTo(transaction.getAccountTo());
        setExpenseCategory(transaction.getExpenseCategory());
        setSum(transaction.getSum());
        setCurrencyShortname(transaction.getCurrencyShortName());
        setDatetime(transaction.getDatetime());
        if(transaction.getLimit() != null) {
            setLimit(new LimitRequest(transaction.getLimit()));
        }
    }
    public Transaction toTransaction() {
        Transaction transaction = new Transaction(
                getAccountFrom(),
                getAccountTo(),
                getExpenseCategory(),
                getDatetime(),
                getSum()
        );
        return transaction;
    }

    public Long getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Long accountTo) {
        this.accountTo = accountTo;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public Long getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Long accountFrom) {
        this.accountFrom = accountFrom;
    }

    public LimitRequest getLimit() {
        return limit;
    }

    public void setLimit(LimitRequest limit) {
        this.limit = limit;
    }

    public String getCurrencyShortname() {
        return currencyShortname;
    }

    public void setCurrencyShortname(String currencyShortname) {
        this.currencyShortname = currencyShortname;
    }
}
