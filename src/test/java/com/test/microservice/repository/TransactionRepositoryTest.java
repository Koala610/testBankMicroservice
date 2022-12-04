package com.test.microservice.repository;

import com.test.microservice.entity.AbstractEntity;
import com.test.microservice.entity.ExpenseCategory;
import com.test.microservice.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TransactionRepositoryTest extends CrudRepositoryTest{
    @Autowired
    public TransactionRepositoryTest(TransactionRepository mainRepository, ExpenseCategoryRepository additionalRepository) {
        super(mainRepository, additionalRepository);
    }

    public AbstractEntity createTestEntity() {
        Transaction transaction = new Transaction(1234567890L, 9876543210L, new ExpenseCategory("TransactionTest"), new Date(System.currentTimeMillis()));
        return (AbstractEntity) mainRepository.save(transaction);
    }
    public void deleteTestEntity(AbstractEntity entity) {
        Transaction transaction =(Transaction) entity;
        mainRepository.delete(transaction);
        additionalRepository.delete(transaction.getExpenseCategory());
    }
    public AbstractEntity updateTestEntity(AbstractEntity entity) {
        Transaction transaction = (Transaction) entity;
        transaction.setSum(99.99);
        return (AbstractEntity) mainRepository.save(transaction);
    }
}
