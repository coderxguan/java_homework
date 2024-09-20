package com.guanhf.a07bank;

public class CheckingAccount extends BankAccount{

    private double serviceCharge;

    public CheckingAccount(String accountNum, double balance, double serviceCharge) {
        super(accountNum, balance);
        this.serviceCharge = serviceCharge;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }
}
