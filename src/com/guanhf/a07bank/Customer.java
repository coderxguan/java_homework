package com.guanhf.a07bank;

public class Customer {
    private String ssn;
    private String name;
    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;

    public Customer(String ssn, String name, CheckingAccount checkingAccount, SavingAccount savingAccount) {
        this.ssn = ssn;
        this.name = name;
        this.checkingAccount = checkingAccount;
        this.savingAccount = savingAccount;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +
                ", checkingAccount=" + checkingAccount +
                ", savingAccount=" + savingAccount +
                '}';
    }
}
