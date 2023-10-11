package com.example.ilyas.solidbankapplication.service;





import com.example.ilyas.solidbankapplication.entities.Account;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@AllArgsConstructor
public class AccountBasicCLI {

    private CreateAccountOperationUI createAccountOperationUI;

    private BankCore bankCore;

    private AccountListingService accountListingService;

    public void createAccountRequest(int clientID) {
        String accountType = createAccountOperationUI.requestAccountType();
        if (accountType  == null) {
            return;
        }
        bankCore.createNewAccount(accountType,clientID);
    }

    public void getAccounts (int clientID) {
        List<Account> clientAccounts = accountListingService.getClientAccounts(clientID);
        System.out.print("[");
        System.out.print(clientAccounts.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", ")));
        System.out.println(']');
    }
}
