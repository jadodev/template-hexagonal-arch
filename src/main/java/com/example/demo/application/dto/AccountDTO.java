package com.example.demo.application.dto;

import com.example.demo.domain.type.AccountType;

public class AccountDTO {
    private long userId;
    private String number;
    private String name;
    private String lastname;
    private AccountType type;
    private double amount;
    private int securityNumber;

    public AccountDTO(long userId, String number, String name, String lastname, AccountType type, double amount, int securityNumber) {
        this.userId = userId;
        this.number = number;
        this.name = name;
        this.lastname = lastname;
        this.type = type;
        this.amount = amount;
        this.securityNumber = securityNumber;
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }


    public AccountType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

}
