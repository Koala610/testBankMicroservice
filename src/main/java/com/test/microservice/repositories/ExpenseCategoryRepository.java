package com.test.microservice.repositories;

import com.test.microservice.entities.ExpenseCategory;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseCategoryRepository extends CrudRepository<ExpenseCategory, Integer> {
}
