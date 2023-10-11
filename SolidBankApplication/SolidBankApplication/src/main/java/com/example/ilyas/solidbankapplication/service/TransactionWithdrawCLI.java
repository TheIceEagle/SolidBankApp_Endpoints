package com.example.ilyas.solidbankapplication.service;



import com.example.ilyas.solidbankapplication.entities.AccountWithdraw;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListingService;



    public void withdrawMoney(int clientID) {

          String accountAccountId = withdrawDepositOperationCLIUI.requestClientAccountNumber();
          double moneyToWithdraw = withdrawDepositOperationCLIUI.requestClientAmount();
          AccountWithdraw accountWithdraw = accountListingService.getClientWithdrawAccount(clientID,accountAccountId);
          if (accountWithdraw == null) {
              System.out.println("Error, you there was no Withdraw Account found by this ID");
              return;
          }

          transactionWithdraw.execute(accountWithdraw,moneyToWithdraw);
        }
    }
