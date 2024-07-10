package org.example;

import jakarta.persistence.*;
import org.example.model.SCBAccount;
import org.example.model.SCBBank;
import org.example.model.Transaction;
import org.h2.tools.Server;

import java.util.List;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("scb");
        EntityManager manager = factory.createEntityManager();

        try {
            manager.getTransaction().begin();

            SCBBank b1 = new SCBBank("Chartered1", "SCB002", "SIPCOT", "Chennai");
            SCBAccount account1 = new SCBAccount("ACC001", "Vivek", "1990-01-01", "Savings", 1000.0);
            SCBAccount account2 = new SCBAccount("ACC002", "Adarsh", "1995-05-05", "Current", 5000.0);



            Transaction transaction1 = new Transaction("2024-06-18");
            Transaction transaction2 = new Transaction("2024-06-19");

            account1.addTransaction(transaction1);
            account2.addTransaction(transaction2);

            b1.addAccount(account1);
            b1.addAccount(account2);

            manager.persist(b1);

            manager.getTransaction().commit();

            SCBBank fetchedBank = manager.find(SCBBank.class, b1.getId());
            System.out.println("Fetched bank with accounts: " + fetchedBank);
            for (SCBAccount account : fetchedBank.getAccounts()) {
                System.out.println("Account: " + account);
                for (Transaction transaction : account.getTransactions()) {
                    System.out.println("Transaction: " + transaction);
                }
            }

            Server webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
            webServer.start();


            // Example JPQL queries

            Query selectQuery = manager.createQuery(
                    "SELECT a FROM SCBAccount a WHERE a.name LIKE :name", SCBAccount.class);
            selectQuery.setParameter("name", "%Vivek%");
            List<SCBAccount> accountsByName = selectQuery.getResultList();

            System.out.println("Accounts with name like 'Vivek':");
            for (SCBAccount account : accountsByName) {
                System.out.println("Account: " + account);
            }


            manager.getTransaction().begin();
            Query updateQuery = manager.createQuery(
                    "UPDATE SCBAccount a SET a.name = :newName WHERE a.name = :oldName");
            updateQuery.setParameter("newName", "NewName");
            updateQuery.setParameter("oldName", "Vivek");
            int updatedCount = updateQuery.executeUpdate();
            manager.getTransaction().commit();

            System.out.println("Updated " + updatedCount + " accounts.");



        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        } finally {
            manager.close();
            factory.close();
        }
    }
}
