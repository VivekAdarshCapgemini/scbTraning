package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "scb_bank")
public class SCBBank extends BankingEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ifsc")
    private String ifsc;

    @Column(name = "branch")
    private String branch;

    @Column(name = "address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SCBAccount> accounts = new ArrayList<>();

    public SCBBank() {
    }

    public SCBBank(String name, String ifsc, String branch, String address) {
        this.name = name;
        this.ifsc = ifsc;
        this.branch = branch;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<SCBAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<SCBAccount> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(SCBAccount account) {
        accounts.add(account);
        account.setBank(this);
    }

    public void removeAccount(SCBAccount account) {
        accounts.remove(account);
        account.setBank(null);
    }

    @Override
    public String toString() {
        return "SCBBank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ifsc='" + ifsc + '\'' +
                ", branch='" + branch + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
