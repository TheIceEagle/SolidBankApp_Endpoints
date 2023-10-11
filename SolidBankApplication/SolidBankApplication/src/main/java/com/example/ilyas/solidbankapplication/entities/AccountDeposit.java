package com.example.ilyas.solidbankapplication.entities;


public class AccountDeposit extends Account {
    public AccountDeposit(String accountType, String id, int clientID, double balance) {
        super(accountType, id, clientID, balance, false);
    }
}
