package com.example.ilyas.solidbankapplication.service;




import com.example.ilyas.solidbankapplication.entities.Account;
import com.example.ilyas.solidbankapplication.entities.AccountWithdraw;
import com.example.ilyas.solidbankapplication.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AccountListingServiceImpl implements AccountListingService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getClientAccount(int clientID, String accountID) {
        return accountRepository.getClientAccount(clientID,accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(int clientID, String accountID) {
        return accountRepository.getClientWithdrawAccount(clientID,accountID);
    }

    @Override
    public List<Account> getClientAccounts(int clientID) {
        return accountRepository.getClientAccounts(clientID);
        //        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(int clientID, String accountType) {
        return accountRepository.getClientAccountsByType(clientID,accountType);
    }






}
