package com.keyin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void testTransactionCreation() {
        Transaction transaction = new Transaction("Deposit", 100.0);
        assertEquals("Deposit", transaction.getType());
        assertEquals(100.0, transaction.getAmount());
        assertNotNull(transaction.getTimestamp());
    }

    @Test
    void testTransactionHistory() {
        BankAccount account = new BankAccount("12345", "Checking", 0.0);
        account.deposit(100.0);
        account.withdraw(50.0);

        assertEquals(2, account.getTransactions().size());
        assertEquals("Deposit", account.getTransactions().get(0).getType());
        assertEquals("Withdrawal", account.getTransactions().get(1).getType());
    }
}
