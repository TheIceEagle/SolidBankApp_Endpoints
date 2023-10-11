package com.example.ilyas.solidbankapplication.entities;

public class FixedAccount extends AccountDeposit {
    public FixedAccount(String accountType, String id, int clientID, double balance) {
        super(accountType, id, clientID, balance);
    }
}
