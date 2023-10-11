package com.example.ilyas.solidbankapplication.service;


import com.example.ilyas.solidbankapplication.entities.AccountWithdraw;

public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw account);
}
