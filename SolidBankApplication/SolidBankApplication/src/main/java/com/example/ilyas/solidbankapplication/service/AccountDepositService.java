package com.example.ilyas.solidbankapplication.service;


import com.example.ilyas.solidbankapplication.entities.Account;

public interface AccountDepositService {


    void deposit(double amount, Account account);
}
