package com.example.demo.domain.entity;

import com.example.demo.domain.type.AccountType;

public class Client {
    private final long identification;
    private String name;
    private String lastname;
    private Account account;

    public Client(long identification, String name, String lastname, AccountType accountType) {
        this.identification = identification;
        this.name = name;
        this.lastname = lastname;
        this.account = new Account( identification, name, lastname, accountType);
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

    public Account getAccount() {
        return account;
    }

}
