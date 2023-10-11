package com.example.ilyas.solidbankapplication.entities;


public class AccountWithdraw extends Account {
    public AccountWithdraw(String accountType, String id, int clientID, double balance) {
        super(accountType, id, clientID, balance, true);
    }
}
