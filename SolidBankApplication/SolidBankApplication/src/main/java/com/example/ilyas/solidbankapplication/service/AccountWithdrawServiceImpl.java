package com.example.ilyas.solidbankapplication.service;



import com.example.ilyas.solidbankapplication.entities.AccountWithdraw;
import com.example.ilyas.solidbankapplication.repository.AccountRepository;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class AccountWithdrawServiceImpl implements AccountWithdrawService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        accountRepository.updateAccount(account.getId(), account.getBalance() - amount);
    }
}
