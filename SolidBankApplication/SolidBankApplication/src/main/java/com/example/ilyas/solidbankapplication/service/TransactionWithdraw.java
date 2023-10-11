package com.example.ilyas.solidbankapplication.service;




import com.example.ilyas.solidbankapplication.entities.AccountWithdraw;
import com.example.ilyas.solidbankapplication.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
public class TransactionWithdraw {
    @Autowired
    private AccountWithdrawService accountWithdrawService;

    @Autowired
    private TransactionRepository transactionRepository;


    public void execute(AccountWithdraw accountWithdraw, double amount) {
        if (accountWithdraw.getBalance() > amount) {
            accountWithdrawService.withdraw(amount,accountWithdraw);
            transactionRepository.addTransaction(accountWithdraw.getId(),amount,"withdraw");
        } else {
            System.out.println("You dont have sufficient funds for this operation");
        }
    }
}
