package org.example.dao;

import org.example.model.SCBAccount;
import org.example.model.Transaction;

public interface BankDAO {
    boolean deposit(SCBAccount account, double amount, Transaction transaction);
    boolean withdraw(SCBAccount account, double amount, Transaction transaction);
    double checkBalance(SCBAccount account);
}
