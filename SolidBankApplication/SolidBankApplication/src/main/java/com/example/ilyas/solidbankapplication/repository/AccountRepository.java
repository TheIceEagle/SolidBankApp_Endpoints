package com.example.ilyas.solidbankapplication.repository;


import com.example.ilyas.solidbankapplication.entities.Account;
import com.example.ilyas.solidbankapplication.entities.AccountWithdraw;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

;import java.util.List;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query("SELECT * FROM  Account a WHERE a.client_id = :clientID")
    List<Account> getClientAccounts(int clientID);

    @Modifying
    @Query(
            "INSERT INTO Account  (account_id, account_type, client_id, balance, withdraw_allowed) VALUES (:id, " +
                    ":accountType, :clientID, :balance, :withdrawAllowed)"
    )
    void createNewAccount(String id, String accountType, int clientID, double balance, boolean withdrawAllowed);

    @Modifying
    @Query("UPDATE Account SET balance = :amount WHERE account_id = :id")
    void updateAccount( String id, double amount);

    @Query("SELECT * FROM Account a WHERE a.client_id = :clientID AND a.account_type = :accountType")
    List<Account> getClientAccountsByType(int clientID, String accountType);

    @Query("SELECT * FROM Account a WHERE a.client_id = :clientID AND a.account_id = :id AND a.withdraw_allowed = true")
    AccountWithdraw getClientWithdrawAccount(int clientID, String id);

    @Query("SELECT * FROM Account a WHERE a.client_id = :clientID AND a.account_id = :id")
    Account getClientAccount(int clientID, String id);

    @Query("SELECT * FROM Account  WHERE account_id = :accountID")
    Account getAccount( String accountID);
    @Modifying
    @Query("DELETE FROM Account a where a.account_id = :accountID")
    void deleteAccountByAccountId(String accountID);

}
