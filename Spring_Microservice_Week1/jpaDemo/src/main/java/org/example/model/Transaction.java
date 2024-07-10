package org.example.model;

import jakarta.persistence.*;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction extends BankingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private SCBAccount account;

    public Transaction() {
    }

    public Transaction(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SCBAccount getAccount() {
        return account;
    }

    public void setAccount(SCBAccount account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", account=" + account +
                '}';
    }
}
