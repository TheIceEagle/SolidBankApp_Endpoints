package com.example.ilyas.solidbankapplication.service;

import java.util.Scanner;

public class MyCLI implements CLIUI {

    Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    private void inputAgain() {
        System.out.println("Error, that is not a valid input, try again!");
        this.scanner.next();
    }

    public double requestClientAmount() {
        System.out.println("Type amount of money");
        double amount;
        while (true) {
            if (!this.scanner.hasNextDouble()) {
                inputAgain();
                continue;
            }
            amount = this.scanner.nextDouble();
            if (amount < 0) {
                inputAgain();
                continue;
            }
            break;
        }
        this.scanner.nextLine();
        return amount;
    }

    @Override
    public String requestClientAccountNumber() {
        System.out.println("Type Account ID");
            String clientAccountNumber = scanner.nextLine().trim();
            return clientAccountNumber;
        }

    public String requestAccountType() {
        System.out.println("Choose account type \n [CHECKING, SAVING, FIXED]");
        while (true) {
            String accountTypeName = this.scanner.nextLine().trim();
            if (!accountTypeName.equals("CHECKING") && !accountTypeName.equals("SAVING") && !accountTypeName.equals("FIXED")) {
                System.out.println("Please enter valid account type");
            } else {
                return accountTypeName;
            }
        }
    }
}




