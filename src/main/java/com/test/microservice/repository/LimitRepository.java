package com.test.microservice.repository;

import com.test.microservice.entity.ExpenseCategory;
import com.test.microservice.entity.Limit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LimitRepository extends CrudRepository<Limit, Long> {
    @Query("select l from Limit l where l.limitSum= ?1")
    List<Limit> findByLimitSum(double limitSum);
    @Query("select l from Limit l where l.accountId = ?1")
    List<Limit> findByAccountId(Long accountId);
    @Query("select l from Limit l where l.accountId = ?1 and l.expenseCategory = ?2 and l.isActual= ?3")
    Optional<Limit> findByAccountIdAndExpenseCategoryAndActuality(Long accountId, ExpenseCategory expenseCategory, boolean isActual);
    @Query("select l from Limit l where l.accountId = ?1 and l.isActual = ?2")
    List<Limit> findByAccountIdAnActuality(Long accountId, boolean isActual);
    @Query("select l from Limit l where  l.isActual = ?2")
    List<Limit> findByActuality(boolean isActual);
}
