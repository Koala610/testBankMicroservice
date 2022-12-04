package com.test.microservice.repository;

import com.test.microservice.entity.AbstractEntity;
import com.test.microservice.entity.ExpenseCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ExpenseCategoryRepositoryTest extends CrudRepositoryTest{
    @Autowired
    public ExpenseCategoryRepositoryTest(ExpenseCategoryRepository repository) {
        super(repository);
    }

    @Override
    public AbstractEntity createTestEntity() {
        ExpenseCategory category = new ExpenseCategory("CreateTest");
        return (AbstractEntity) mainRepository.save(category);
    }


    @Override
    public void deleteTestEntity(AbstractEntity entity) {
        mainRepository.delete((ExpenseCategory) entity);
    }

    @Override
    public AbstractEntity updateTestEntity(AbstractEntity entity) {
        ExpenseCategory category = (ExpenseCategory) entity;
        category.setName("UpdateTestNew");
        ExpenseCategory updatedCategory = (ExpenseCategory) mainRepository.save(category);
        return updatedCategory;
    }

    //TODO: unify crud operations testing. Idea: create abstract entity class and abstract CrudRepositoryTest class

}
