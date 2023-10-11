package com.example.ilyas.solidbankapplication.service;





import com.example.ilyas.solidbankapplication.entities.Account;
import com.example.ilyas.solidbankapplication.entities.AccountWithdraw;

import java.util.List;

public interface AccountListingService {
    Account getClientAccount (int clientID, String accountID);
    AccountWithdraw getClientWithdrawAccount (int clientID, String accountID);

    List<Account> getClientAccounts(int clientID);

    List<Account> getClientAccountsByType(int clientID, String accountType);


}
