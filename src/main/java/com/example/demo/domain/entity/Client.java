package com.example.demo.domain.entity;

import java.util.List;

public class Client {
    private long identification;
    private String name;
    private String lastname;
//    private List<Account> accounts;

    public Client(long identification, String name, String lastname){
        this.identification = identification;
        this.name = name;
        this.lastname = lastname;
//        this.accounts = accounts;
    }

    public long getIdentification() {
        return identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

//    public List<Account> getAccounts() {
//        return accounts;
//    }
//
//    public void setAccounts(List<Account> accounts) {
//        this.accounts = accounts;
//    }
}
