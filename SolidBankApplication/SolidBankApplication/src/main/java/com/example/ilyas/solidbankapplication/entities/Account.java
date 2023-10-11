package com.example.ilyas.solidbankapplication.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "ACCOUNT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private @Column(value = "account_type") String accountType;
    private @Id @Column(value = "account_id") String id;
    private @Column(value = "client_id") int clientID;
    private @Column(value = "balance") double balance;
    private @Column(value = "withdraw_allowed") boolean withdrawAllowed;
    @Override
    public String toString() {
        return String.format("Account{accountType=%s, id='%s', clientID='%s', balance=%.1f}", accountType, id, clientID, balance);
    }


}
