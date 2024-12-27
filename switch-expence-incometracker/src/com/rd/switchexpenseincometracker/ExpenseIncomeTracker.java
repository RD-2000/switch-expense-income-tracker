package com.rd.switchexpenseincometracker;

import com.rd.switchexpenseincometracker.model.Transaction;
import com.rd.switchexpenseincometracker.service.TrackerService;

import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseIncomeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrackerService trackerService = new TrackerService();
        boolean running = true;

        System.out.println("Welcome to the Expense-Income Tracker!");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter income amount: ");
                    double income = scanner.nextDouble();
                    trackerService.addIncome(income);
                    System.out.println("Income added successfully.");
                    break;

                case 2:
                    System.out.print("Enter expense amount: ");
                    double expense = scanner.nextDouble();
                    trackerService.addExpense(expense);
                    System.out.println("Expense added successfully.");
                    break;

                case 3:
                    System.out.println("Current balance: " + trackerService.getBalance());
                    break;

                case 4:
                    ArrayList<Transaction> transactions = trackerService.getTransactions();
                    System.out.println("Transaction History:");
                    if (transactions.isEmpty()) {
                        System.out.println("No transactions recorded yet.");
                    } else {
                        for (Transaction transaction : transactions) {
                            System.out.println(transaction);
                        }
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting the tracker");
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }
}


