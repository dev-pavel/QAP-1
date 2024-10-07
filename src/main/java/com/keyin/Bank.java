package com.keyin;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findAccount(String accountNumber) {
        return accounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    public boolean transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        if (fromAccount != null && toAccount != null && fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
