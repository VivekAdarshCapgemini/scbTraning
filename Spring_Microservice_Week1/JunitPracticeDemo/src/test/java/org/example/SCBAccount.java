package org.example;

import java.time.LocalDate;
import java.time.Period;

public class SCBAccount {
    private int accno;
    private String name;
    private LocalDate dob;
    private String accountType;
    private double balance;

    public SCBAccount(int accno, String name, LocalDate dob, String accountType, double balance) {
        this.accno = accno;
        this.name = name;
        this.dob = dob;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getAccno() {
        return accno;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isEligibleToCreateAccount() {
        LocalDate now = LocalDate.now();
        int age = Period.between(dob, now).getYears();
        return age > 18;
    }
}
