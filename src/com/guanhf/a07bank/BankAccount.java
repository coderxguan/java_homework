package com.guanhf.a07bank;

public class BankAccount {
    private String accountNum;
    private double balance;

    public BankAccount(String accountNum, double balance) {
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNum + ", Balance: " + balance;
    }
}
