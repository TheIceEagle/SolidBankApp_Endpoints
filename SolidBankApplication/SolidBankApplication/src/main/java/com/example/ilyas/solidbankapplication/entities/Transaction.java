package com.example.ilyas.solidbankapplication.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "Transactions")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {

    @Column(value = "account_id")
    private long accountID;

    @Column(value = "amount")
    private double amount;

    @Column(value = "type")
    public String type;
}