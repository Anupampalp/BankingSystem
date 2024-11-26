package com.Bank;

import java.io.*;

public class Account {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public Account(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds!");
        }
    }

    // Save account details to a file
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt", true))) {
            writer.write(accountNumber + "," + accountHolderName + "," + balance);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving account to file: " + e.getMessage());
        }
    }

    // Display Account Information
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    // Static method to load and display all accounts from the file
    public static void loadAccountsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))) {
            String line;
            System.out.println("\nStored Accounts:");
            while ((line = reader.readLine()) != null) {
                String[] accountDetails = line.split(",");
                System.out.println("Account Number: " + accountDetails[0] +
                        ", Account Holder: " + accountDetails[1] +
                        ", Balance: " + accountDetails[2]);
            }
        } catch (IOException e) {
            System.out.println("Error reading accounts file: " + e.getMessage());
        }
    }

}
