package com.keyin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount("12345", "Checking", 0.0);
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount("12345", "Savings", 0.0);
        account.deposit(200.0);
        boolean success = account.withdraw(100.0);
        assertTrue(success);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void testInsufficientFunds() {
        BankAccount account = new BankAccount("12345", "Checking", 0.0);
        boolean success = account.withdraw(100.0);
        assertFalse(success);
    }
}
