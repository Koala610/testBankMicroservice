package com.test.microservice.repository;

import com.test.microservice.entity.AbstractEntity;
import com.test.microservice.entity.ExpenseCategory;
import com.test.microservice.entity.Limit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class LimitRepositoryTest extends  CrudRepositoryTest{
    @Autowired
    public LimitRepositoryTest(LimitRepository mainRepository, ExpenseCategoryRepository additionalRepository) {
        super(mainRepository, additionalRepository);
    }
    public AbstractEntity createTestEntity() {
        ExpenseCategory expenseCategory = new ExpenseCategory("LimitTest");
        Limit limit = new Limit((long) new Random().nextInt(9999), 12.34, expenseCategory);
        return (AbstractEntity) mainRepository.save(limit);
    }

    public void deleteTestEntity(AbstractEntity entity) {
        Limit limit = (Limit) entity;
        mainRepository.delete(limit);
        additionalRepository.delete(limit.getExpenseCategory());
    }

    public AbstractEntity updateTestEntity(AbstractEntity entity) {
        Limit limit = (Limit) entity ;
        limit.setLimitSum(55.55);
        return (AbstractEntity) mainRepository.save(limit);
    }

}
