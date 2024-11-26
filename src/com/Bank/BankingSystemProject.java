package com.Bank;

import java.util.Scanner;

public class BankingSystemProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Account Information");
            System.out.println("5. View All Stored Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String accName = scanner.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double initialDeposit = scanner.nextDouble();

                    Account newAccount = new Account(accNum, accName, initialDeposit);
                    newAccount.saveToFile();
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNum = scanner.nextLine();
                    // In real-world applications, you would retrieve account from the database or memory.
                    System.out.print("Enter Amount to Deposit: ");
                    double depositAmount = scanner.nextDouble();
                    // For simplicity, this example does not persist runtime updates.
                    System.out.println("Deposit feature simulated!");
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNum = scanner.nextLine();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println("Withdrawal feature simulated!");
                    break;

                case 4:
                    System.out.println("Feature not implemented for runtime accounts.");
                    break;

                case 5:
                    Account.loadAccountsFromFile();
                    break;

                case 6:
                    System.out.println("Thank you for using the Banking System!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
