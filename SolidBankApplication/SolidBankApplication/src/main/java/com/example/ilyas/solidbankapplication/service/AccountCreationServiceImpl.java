package com.example.ilyas.solidbankapplication.service;


import com.example.ilyas.solidbankapplication.entities.Account;
import com.example.ilyas.solidbankapplication.entities.CheckingAccount;
import com.example.ilyas.solidbankapplication.entities.FixedAccount;
import com.example.ilyas.solidbankapplication.entities.SavingAccount;
import com.example.ilyas.solidbankapplication.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class AccountCreationServiceImpl implements AccountCreationService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public void create(String accountType, long bankID, int clientID, String accountID) {
        Account account = switch (accountType) {
            case "SAVING" -> new SavingAccount(accountType, accountID, clientID, 0);
            case "CHECKING" -> new CheckingAccount(accountType, accountID, clientID, 0);
            case "FIXED" -> new FixedAccount(accountType, accountID, clientID, 0);
            default -> throw new IllegalStateException("Unexpected value: " + accountType);
        };
        accountRepository.createNewAccount(account.getId(), account.getAccountType(), account.getClientID(),
                account.getBalance(), account.isWithdrawAllowed());
    }
}



