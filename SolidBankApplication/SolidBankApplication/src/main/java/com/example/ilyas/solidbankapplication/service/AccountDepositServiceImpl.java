package com.example.ilyas.solidbankapplication.service;



import com.example.ilyas.solidbankapplication.entities.Account;
import com.example.ilyas.solidbankapplication.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class AccountDepositServiceImpl implements AccountDepositService {
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public void deposit(double amount, Account account) {
        accountRepository.updateAccount(account.getId(),(account.getBalance()+amount));
    }

}
