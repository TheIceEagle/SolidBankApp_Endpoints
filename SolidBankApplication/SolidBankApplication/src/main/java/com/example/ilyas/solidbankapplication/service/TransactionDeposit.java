package com.example.ilyas.solidbankapplication.service;


import com.example.ilyas.solidbankapplication.entities.Account;
import com.example.ilyas.solidbankapplication.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
public class TransactionDeposit {
    @Autowired
    private AccountDepositService accountDepositService;

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDeposit(AccountDepositService accountDepositService) {
        this.accountDepositService = accountDepositService;
    }


    public void execute(Account account, double amount) {
        accountDepositService.deposit(amount, account);
        transactionRepository.addTransaction(account.getId(),amount,"deposit");
    }
}
