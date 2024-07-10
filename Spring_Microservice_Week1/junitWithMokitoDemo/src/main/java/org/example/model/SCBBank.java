package org.example.model;

import java.util.List;

public class SCBBank {
    private String name;
    private String ifsc;
    private String branch;
    private String address;
    private List<SCBAccount> accounts;

    public SCBBank(String name, String ifsc, String branch, String address, List<SCBAccount> accounts) {
        this.name = name;
        this.ifsc = ifsc;
        this.branch = branch;
        this.address = address;
        this.accounts = accounts;
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

    @Override
    public String toString() {
        return "SCBBank{" +
                "name='" + name + '\'' +
                ", ifsc='" + ifsc + '\'' +
                ", branch='" + branch + '\'' +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
