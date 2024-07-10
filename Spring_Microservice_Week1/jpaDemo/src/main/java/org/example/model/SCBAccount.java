package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "scb_account")
public class SCBAccount extends BankingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accno")
    private String accNo;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private String dob;

    @Column(name = "accounttype")
    private String accountType;

    @Column(name = "balance")
    private double balance;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private SCBBank bank;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    public SCBAccount() {
    }

    public SCBAccount(String accNo, String name, String dob, String accountType, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.dob = dob;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
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

    public SCBBank getBank() {
        return bank;
    }

    public void setBank(SCBBank bank) {
        this.bank = bank;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setAccount(this);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
        transaction.setAccount(null);
    }

    @Override
    public String toString() {
        return "SCBAccount{" +
                "id=" + id +
                ", accNo='" + accNo + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", bank=" + bank +
                '}';
    }
}
