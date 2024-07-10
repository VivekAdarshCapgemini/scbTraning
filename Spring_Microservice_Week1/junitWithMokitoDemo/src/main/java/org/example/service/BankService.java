package org.example.service;

import org.example.dao.BankDAO;
import org.example.model.SCBAccount;
import org.example.model.Transaction;

public class BankService {
    private BankDAO bankDAO;

    public BankService(BankDAO bankDAO) {
        this.bankDAO = bankDAO;
    }

    public boolean deposit(SCBAccount account, double amount, Transaction transaction) {
        return bankDAO.deposit(account, amount, transaction);
    }

    public boolean withdraw(SCBAccount account, double amount, Transaction transaction) {
        return bankDAO.withdraw(account, amount, transaction);
    }

    public double checkBalance(SCBAccount account) {
        return bankDAO.checkBalance(account);
    }
}
