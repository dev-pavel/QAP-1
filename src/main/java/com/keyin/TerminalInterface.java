package com.keyin;

import java.util.Scanner;

public class TerminalInterface {
    private final Scanner scanner;
    private final Bank bank;

    public TerminalInterface(Bank bank) {
        this.scanner = new Scanner(System.in);
        this.bank = bank;
    }

    public void start() {
        while (true) {
            System.out.println("Welcome to the Bank Account Management System!");
            System.out.println("1. Add Account");
            System.out.println("2. Find Account");
            System.out.println("3. Transfer Funds");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    findAccount();
                    break;
                case 3:
                    transferFunds();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account type: ");
        String accountType = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();


        BankAccount newAccount = new BankAccount(accountNumber, accountType, initialBalance);
        bank.addAccount(newAccount);
        System.out.println("Account added successfully: " + newAccount);
    }

    private void findAccount() {
        System.out.print("Enter account number to find: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = bank.findAccount(accountNumber);

        if (account != null) {
            System.out.println("Account found: " + account);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void transferFunds() {
        System.out.print("Enter from account number: ");
        String fromAccountNumber = scanner.nextLine();
        System.out.print("Enter to account number: ");
        String toAccountNumber = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        boolean success = bank.transferFunds(fromAccountNumber, toAccountNumber, amount);
        if (success) {
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Transfer failed. Check account numbers or insufficient funds.");
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        TerminalInterface terminalInterface = new TerminalInterface(bank);
        terminalInterface.start();
    }
}
