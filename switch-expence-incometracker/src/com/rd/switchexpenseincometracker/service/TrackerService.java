package com.rd.switchexpenseincometracker.service;

import com.rd.switchexpenseincometracker.model.Transaction;

import java.util.ArrayList;

public class TrackerService {
    private double balance;
    private ArrayList<Transaction> transactions;

    public TrackerService() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void addIncome(double income) {
        if (income > 0) {
            balance += income;
            transactions.add(new Transaction("Income", income));
        } else {
            System.out.println("Income amount must be positive.");
        }
    }

    public void addExpense(double expense) {
        if (expense > 0) {
            if (expense <= balance) {
                balance -= expense;
                transactions.add(new Transaction("Expense", expense));
            } else {
                System.out.println("Insufficient balance for this expense.");
            }
        } else {
            System.out.println("Expense amount must be positive.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}



