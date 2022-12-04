package com.test.microservice.repository;

import com.test.microservice.entity.ExpenseCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ExpenseCategoryRepositoryTest {
    @Autowired
    private ExpenseCategoryRepository repository;

    public ExpenseCategory createTestExpenseCategory(String name) {
        ExpenseCategory category = new ExpenseCategory(name);
        category = repository.save(category);
        return category;

    }

    @Test
    public void testCreation() {

        long prev_size = repository.count();
        ExpenseCategory category = createTestExpenseCategory("CreateTest");
        List<ExpenseCategory> categoryList = (List<ExpenseCategory>) repository.findAll();
        assertThat(categoryList).hasSize((int) (prev_size+1));
        repository.delete(category);
    }

    @Test
    public void testDeletion() {
        long prev_size = repository.count();
        ExpenseCategory category = createTestExpenseCategory("DeleteTest");
        repository.delete(category);
        List<ExpenseCategory> categoryList = (List<ExpenseCategory>) repository.findAll();
        assertThat(categoryList).hasSize((int) prev_size);

    }
    @Test
    public void testUpdate() {
        ExpenseCategory category = createTestExpenseCategory("UpdateTest");
        category.setName("UpdateTestNew");
        ExpenseCategory updatedCategory = repository.save(category);
        List<ExpenseCategory> categoryList = repository.findByIdAndName(updatedCategory.getId(), "UpdateTestNew");
        assertThat(categoryList).isNotEmpty();
        repository.delete(updatedCategory);

    }
}
