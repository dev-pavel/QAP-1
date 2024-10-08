package com.keyin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void testAddAccount() {
        Bank bank = new Bank();
        BankAccount account = new BankAccount("12345", "Savings", 0.0);
        bank.addAccount(account);
        assertEquals(1, bank.getAccounts().size());
    }

    @Test
    void testTransferFunds() {
        Bank bank = new Bank();
        BankAccount account1 = new BankAccount("12345", "Checking", 0.0);
        BankAccount account2 = new BankAccount("67890", "Savings", 0.0);

        account1.deposit(200.0);
        bank.addAccount(account1);
        bank.addAccount(account2);

        boolean success = bank.transferFunds("12345", "67890", 100.0);
        assertTrue(success);
        assertEquals(100.0, account1.getBalance());
        assertEquals(100.0, account2.getBalance());
    }

    @Test
    void testTransferInsufficientFunds() {
        Bank bank = new Bank();
        BankAccount account1 = new BankAccount("12345", "Checking", 0.0);
        BankAccount account2 = new BankAccount("67890", "Savings", 0.0);

        account1.deposit(50.0);
        bank.addAccount(account1);
        bank.addAccount(account2);

        boolean success = bank.transferFunds("12345", "67890", 100.0);
        assertFalse(success);
        assertEquals(50.0, account1.getBalance());
        assertEquals(0.0, account2.getBalance());
    }
}