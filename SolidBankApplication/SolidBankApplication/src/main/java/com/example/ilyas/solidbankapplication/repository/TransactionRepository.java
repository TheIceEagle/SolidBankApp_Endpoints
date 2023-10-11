package com.example.ilyas.solidbankapplication.repository;



import com.example.ilyas.solidbankapplication.entities.Transaction;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long> {

    @Query("SELECT * FROM Transaction where account_id = :accountID")
    List<Transaction> getTransaction(String accountID);
    @Modifying
    @Query("INSERT INTO Transaction  (account_id, amount, type) VALUES (:accountID, :amount, :type)")
    void addTransaction(String accountID, double amount, String type);
}
