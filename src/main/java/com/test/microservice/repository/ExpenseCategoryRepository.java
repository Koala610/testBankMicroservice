package com.test.microservice.repositories;

import com.test.microservice.entities.ExpenseCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseCategoryRepository extends CrudRepository<ExpenseCategory, Long> {
    @Query("select c from ExpenseCategory c where c.name = ?1")
    List<ExpenseCategory> findByName(String name);

    @Query("select c from ExpenseCategory c where c.id = ?1 and c.name = ?2")
    List<ExpenseCategory> findByIdAndName(Long id, String name);
}
