package com.example.ilyas.solidbankapplication.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;


    AccountCreationService accountCreationService;


    public BankCore(AccountCreationService accountCreationService){
        this.accountCreationService = accountCreationService;
    }

    public void createNewAccount (String accountType, int clientID) {
        String accountID = String.format("%03d%06d", clientID, lastAccountNumber);
        accountCreationService.create(accountType,id,clientID,accountID);
        incrementLastAccountNumber();
        System.out.println("Bank account created");

    }

    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
