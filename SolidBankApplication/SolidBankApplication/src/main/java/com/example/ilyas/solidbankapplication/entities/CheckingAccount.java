package com.example.ilyas.solidbankapplication.entities;

public class CheckingAccount extends AccountWithdraw {
    public CheckingAccount(String accountType, String id, int clientID, double balance) {
        super(accountType, id, clientID, balance);
    }
}
