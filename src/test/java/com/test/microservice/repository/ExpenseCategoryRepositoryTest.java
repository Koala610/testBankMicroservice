package com.test.microservice.repository;

import com.test.microservice.entities.ExpenseCategory;
import com.test.microservice.repositories.ExpenseCategoryRepository;
import jdk.jfr.Category;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ExpenseCategoryRepositoryTest {
    @Autowired
    private ExpenseCategoryRepository repository;

    @Test
    public void testCreation() {

        long prev_size = repository.count();
        ExpenseCategory category = new ExpenseCategory("CreateTest");
        category = repository.save(category);
        List<ExpenseCategory> categoryList = (List<ExpenseCategory>) repository.findAll();
        assertThat(categoryList).hasSize((int) (prev_size+1));
        repository.delete(category);
    }

    @Test
    public void testDeletion() {
        long prev_size = repository.count();
        ExpenseCategory category = new ExpenseCategory("DeleteTest");
        category = repository.save(category);
        repository.delete(category);
        List<ExpenseCategory> categoryList = (List<ExpenseCategory>) repository.findAll();
        assertThat(categoryList).hasSize((int) prev_size);

    }
    @Test
    public void testUpdate() {
        ExpenseCategory category = new ExpenseCategory("UpdateTest");
        category = repository.save(category);
        category.setName("UpdateTestNew");
        ExpenseCategory updatedCategory = repository.save(category);
        List<ExpenseCategory> categoryList = repository.findByIdAndName(updatedCategory.getId(), "UpdateTestNew");
        assertThat(categoryList).isNotEmpty();
        repository.delete(updatedCategory);

    }
}
