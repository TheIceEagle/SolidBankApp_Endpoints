package com.example.ilyas.solidbankapplication.controller;


import com.example.ilyas.solidbankapplication.DTO.AccountAmountRequest;
import com.example.ilyas.solidbankapplication.DTO.AccountCreateRequest;
import com.example.ilyas.solidbankapplication.entities.Account;
import com.example.ilyas.solidbankapplication.entities.AccountWithdraw;
import com.example.ilyas.solidbankapplication.entities.Transaction;
import com.example.ilyas.solidbankapplication.repository.AccountRepository;
import com.example.ilyas.solidbankapplication.repository.TransactionRepository;
import com.example.ilyas.solidbankapplication.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountListingServiceImpl accountListingService;
    @Autowired
    private AccountCreationServiceImpl accountCreationService;
    @Autowired
    private BankCore bankCore;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountWithdrawServiceImpl accountWithdrawService;
    @Autowired
    private TransactionWithdraw transactionWithdraw;
    @Autowired
    private AccountDepositServiceImpl accountDepositService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionDeposit transactionDeposit;


    @GetMapping()
    List<Account> getAllAccountsByClientID(@RequestParam int clientID) {
       return accountListingService.getClientAccounts(clientID);
    }

    @PostMapping()
    public ResponseEntity<Account>  creatNewAccount(@RequestBody AccountCreateRequest accountCreateRequest){
        HashMap<String,String> message = new HashMap<>();
        try{
             bankCore.createNewAccount(accountCreateRequest.getAccountType(),1);
             message.put("message","Account successfully created");
             return new ResponseEntity(message, HttpStatus.OK);
        } catch (Exception e) {
             message.put("message","Error! Please enter the correct account type");
             return new ResponseEntity(message,HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @GetMapping("/account_id")
    public ResponseEntity<Object> getAccountByAccountID(@RequestParam int clientID, String account_id) {
       Account account = accountListingService.getClientAccount(clientID, account_id);
        HashMap<String,Object> message = new HashMap<>();
        HttpStatus httpStatus;
       if ( account == null) {
           message.put("message","Account was not found");
           httpStatus = HttpStatus.BAD_REQUEST;
           return new ResponseEntity<>(message,httpStatus);
       } else {
           message.put("message",account);
           httpStatus = HttpStatus.OK;
           return new ResponseEntity<>(message,httpStatus);
       }
    }

    @DeleteMapping("/{account_id}")
    public ResponseEntity<?> deleteAccountByAccountId(@PathVariable("account_id") String accountID) {
        HashMap<String,String> message = new HashMap<>();
        if (accountID != null) {
            accountRepository.deleteAccountByAccountId(accountID);
            message.put("message",String.format("Account %s was deleted", accountID));
            return new ResponseEntity(message,HttpStatus.OK);
        } else {
            message.put("message","Account ID was empty, please enter Accout ID");
            return  new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
        }

    }


    @Modifying
    @PostMapping("/{account_id}/withdraw")
    public ResponseEntity<?> withdrawFromAccountByAccountId(@PathVariable("account_id") String accountID, @RequestBody AccountAmountRequest accountAmountRequest) {
        HashMap<String,Object> message = new HashMap<>();
        try {
            AccountWithdraw accountWithdraw = accountListingService.getClientWithdrawAccount(1,accountID);
            if (accountWithdraw.getBalance()<accountAmountRequest.getAmount()) {return new ResponseEntity<>("Error! You dont have sufficient funds for this operation",HttpStatus.BAD_REQUEST); }
            transactionWithdraw.execute(accountWithdraw,accountAmountRequest.getAmount());
            message.put("message",String.format("%.2f was transferred from Account: %s", accountAmountRequest.getAmount(),accountID));
            return new ResponseEntity<>(message,HttpStatus.OK);
        } catch (Exception e) {
            message.put("message","Error! Withrawal is not possible");
            return new ResponseEntity<>(message,HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Modifying
    @PostMapping("/{account_id}/deposit")
    public ResponseEntity<?> depositToAccountByAccountId(@RequestBody AccountAmountRequest accountAmountRequest, @PathVariable("account_id") String accountID) {
        HashMap<String,Object> message = new HashMap<>();
        try {
            Account account = accountListingService.getClientAccount(1,accountID);
            transactionDeposit.execute(account,accountAmountRequest.getAmount());
            message.put("message",String.format("%.2f was transferred to Account: %s",  accountAmountRequest.getAmount(), accountID));
            return new ResponseEntity<>(message,HttpStatus.OK);

        } catch (Exception e) {
            message.put("message","Error! Deposit is not possible");
            return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{account_id}/transactions")
    public List<Transaction> getAllTransactionsByAccountId(@RequestParam String accountID) {
        return transactionRepository.getTransaction(accountID);
    }


    }





