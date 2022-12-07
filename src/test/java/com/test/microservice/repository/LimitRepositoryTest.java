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
    public LimitRepositoryTest(LimitRepository mainRepository) {
        super(mainRepository);
    }
    public AbstractEntity createTestEntity() {
        ExpenseCategory expenseCategory = ExpenseCategory.product;
        Limit limit = new Limit( 123456L, expenseCategory);
        return (AbstractEntity) mainRepository.save(limit);
    }

    public void deleteTestEntity(AbstractEntity entity) {
        Limit limit = (Limit) entity;
        mainRepository.delete(limit);
    }

    public AbstractEntity updateTestEntity(AbstractEntity entity) {
        Limit limit = (Limit) entity ;
        limit.setLimitSum(55.55);
        return (AbstractEntity) mainRepository.save(limit);
    }
    @Test
    public void testGettingByaccountIdAndCategory() {
       Limit limit = (Limit) createTestEntity();
       mainRepository.save(limit);
       Optional<Limit> finalLimit = ((LimitRepository) mainRepository).findByAccountIdAndExpenseCategory(
               limit.getAccountId(),
               limit.getExpenseCategory());
       assertThat(finalLimit).isNotNull();
       deleteTestEntity(limit);
    }

}
