package com.test.microservice.repository;

import com.test.microservice.entity.ExpenseCategory;
import com.test.microservice.entity.Limit;
import com.test.microservice.entity.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TransactionRepositoryTest {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private ExpenseCategoryRepository expenseCategoryRepository;
    public Transaction createTestTransaction() {
        Transaction transaction = new Transaction(1234567890L, 9876543210L, new ExpenseCategory("TransactionTest"), new Date(System.currentTimeMillis()));
        return transactionRepository.save(transaction);
    }
    public void deleteTestTransaction(Transaction transaction) {
        transactionRepository.delete(transaction);
        expenseCategoryRepository.delete(transaction.getExpenseCategory());
    }
    @Test
    public void testCreation() {
        Transaction transaction = createTestTransaction();
        assertThat(transaction).isNotNull();
        transactionRepository.delete(transaction);
    }
    @Test
    public void updateCreation() {
        Transaction transaction = createTestTransaction();
        transaction.setSum(99.99);
        transactionRepository.save(transaction);
        Optional<Transaction> checkTransaction = transactionRepository.findById(transaction.getId());
        assertThat(checkTransaction).isNotNull();
        deleteTestTransaction(transaction);
    }
    @Test
    public void testDelete() {
        long init_len = transactionRepository.count();
        Transaction transaction= createTestTransaction();
        deleteTestTransaction(transaction);
        Iterable<Transaction> limits =  transactionRepository.findAll();
        assertThat(limits).hasSize((int) (init_len));
    }

}
