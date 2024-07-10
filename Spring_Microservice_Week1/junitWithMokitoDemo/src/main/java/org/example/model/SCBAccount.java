package org.example.model;

import java.util.Date;
import java.util.List;

public class SCBAccount {
    private String accno;
    private String name;
    private Date dob;
    private String accountType;
    private double balance;
    private List<Transaction> transactions;

    public SCBAccount(String accno, String name, Date dob, String accountType, double balance, List<Transaction> transactions) {
        this.accno = accno;
        this.name = name;
        this.dob = dob;
        this.accountType = accountType;
        this.balance = balance;
        this.transactions = transactions;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "SCBAccount{" +
                "accno='" + accno + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
