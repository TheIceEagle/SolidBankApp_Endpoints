package com.example.ilyas.solidbankapplication.service;


import com.example.ilyas.solidbankapplication.entities.Account;

public class TransactionDepositCLI {
    private TransactionDeposit transactionDeposit;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public TransactionDepositCLI(TransactionDeposit transactionDeposit, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService) {
        this.transactionDeposit = transactionDeposit;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

    public void depositMoney(int clientID) {
        String accountAccountId = withdrawDepositOperationCLIUI.requestClientAccountNumber();

        Account account = accountListingService.getClientAccount(clientID,accountAccountId);
        if (account == null) {
            System.out.println("Error, you entered wrong account number");
            return;
        }
        double moneyToDeposit = withdrawDepositOperationCLIUI.requestClientAmount();
        transactionDeposit.execute(account, moneyToDeposit);
    }
}
