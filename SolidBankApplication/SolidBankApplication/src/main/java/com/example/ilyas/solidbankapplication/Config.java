package com.example.ilyas.solidbankapplication;


import com.example.ilyas.solidbankapplication.repository.AccountRepository;
import com.example.ilyas.solidbankapplication.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {


    @Bean
    public MyCLI myCLI() {
        return new MyCLI();
    }

    @Bean
    public AccountCreationService accountCreation() {
        return new AccountCreationServiceImpl();
    }

    @Bean
    public AccountListingService accountListing() {
        return new AccountListingServiceImpl();
    }

    @Bean
    public AccountWithdrawService accountWithdrawService() {
        return new AccountWithdrawServiceImpl();
    }

    @Bean
    public AccountDepositService accountDepositService() {
        return new AccountDepositServiceImpl();
    }

    @Bean
    public BankCore bankCore() {
        return new BankCore(accountCreation());
    }

    @Bean
    public AccountBasicCLI accountBasicCLI() {
        return new AccountBasicCLI(myCLI(), bankCore(), accountListing());
    }


    @Bean
    public TransactionWithdraw transactionWithdraw() {
        return new TransactionWithdraw();
    }

    @Bean
    public TransactionWithdrawCLI transactionWithdrawCLI() {
        return new TransactionWithdrawCLI(transactionWithdraw(), myCLI(), accountListing());
    }

    @Bean
    public TransactionDeposit transactionDeposit() {
        return new TransactionDeposit(accountDepositService());
    }

    @Bean
    public TransactionDepositCLI transactionDepositCLI() {
        return new TransactionDepositCLI(transactionDeposit(), myCLI(), accountListing());
    }

}
