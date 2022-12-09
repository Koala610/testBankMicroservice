package com.test.microservice.repository;

import com.test.microservice.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    @Query("select t from Transaction t where t.accountFrom= ?1 and t.limitExceeded= ?2")
    List<Transaction> findByAccountIdAndLimitExceeded(Long accountId, boolean limitExceeded);
}
