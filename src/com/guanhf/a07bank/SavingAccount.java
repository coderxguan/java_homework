package com.guanhf.a07bank;

public class SavingAccount extends BankAccount{
    private double interestRate;

    public SavingAccount(String accountNum, double balance, double interestRate) {
        super(accountNum, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void accrueInterest() {
        setBalance(getBalance() * (1 + interestRate));
    }
}
