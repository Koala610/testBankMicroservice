package com.test.microservice.repository;

import com.test.microservice.entity.ExpenseCategory;
import com.test.microservice.entity.Limit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class LimitRepositoryTest {
    @Autowired
    private LimitRepository limitRepository;
    @Autowired
    private ExpenseCategoryRepository expenseCategoryRepository;
    public Limit createTestLimit() {
        ExpenseCategory expenseCategory = new ExpenseCategory("LimitTest");
        Limit limit = new Limit(123L, 12.34, expenseCategory);
        return limitRepository.save(limit);
    }

    public void deleteTestLimit(Limit limit) {
        limitRepository.delete(limit);
        expenseCategoryRepository.delete(limit.getExpenseCategory());
    }
    @Test
    public void testCreate() {
        Limit limit = createTestLimit();
        Optional<Limit> foundLimit = limitRepository.findById(Long.valueOf(123));
        assertThat(foundLimit).isNotNull();
        deleteTestLimit(limit);
    }

    @Test
    public void testDelete() {
        long init_len = limitRepository.count();
        Limit limit = createTestLimit();
        deleteTestLimit(limit);
        List<Limit> limits = (List<Limit>) limitRepository.findAll();
        assertThat(limits).hasSize((int) (init_len));
    }

    @Test
    public void testUpdate() {
        Limit limit = createTestLimit();
        limit.setLimitSum(55.55);
        limit = limitRepository.save(limit);
        Optional<Limit> checkLimit = limitRepository.findById(limit.getAccountId());
        assertThat(checkLimit).isNotNull();
        deleteTestLimit(limit);
    }
}
