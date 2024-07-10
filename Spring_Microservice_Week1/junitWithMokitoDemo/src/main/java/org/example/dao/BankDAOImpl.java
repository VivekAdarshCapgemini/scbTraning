package org.example.dao;

import org.example.model.SCBAccount;
import org.example.model.Transaction;

public class BankDAOImpl implements BankDAO {

    @Override
    public boolean deposit(SCBAccount account, double amount, Transaction transaction) {

        account.setBalance(account.getBalance() + amount);
        account.getTransactions().add(transaction);
        return true;
    }

    @Override
    public boolean withdraw(SCBAccount account, double amount, Transaction transaction) {

        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            account.getTransactions().add(transaction);
            return true;
        }
        return false;
    }

    @Override
    public double checkBalance(SCBAccount account) {

        return account.getBalance();
    }
}
