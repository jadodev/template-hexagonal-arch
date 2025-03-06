package com.example.demo.domain.entity;

import com.example.demo.domain.type.AccountType;

import java.util.Random;

public class Account {
  private String number;
  private long userId;
  private String name;
  private String lastname;
  private AccountType type;
  private double amount;
  private final int securityNumber;

  public Account(long userId, String name, String lastname, AccountType accountType){
    this.number = generateAccountNumber( userId, accountType);
    this.userId = userId;
    this.name = name;
    this.lastname = lastname;
    this.type = accountType;
    this.amount = 0.0;
    this.securityNumber = generateSecurityNumber();
  }

  private String generateAccountNumber(long userId, AccountType accountType){
      String prefix = (accountType == AccountType.AHORROS) ? "53" : "33";
      return  prefix + userId;
  }

  private int generateSecurityNumber(){
      return  new Random().nextInt(900) + 100;
  }

    public String getNumber() {
        return number;
    }

    public double getAmount() {
        return amount;
    }

    public AccountType getType() {
        return type;
    }

    public void setNumber(String number) {
        this.number = number;
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


    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getSecurityNumber() {
        return securityNumber;
    }

}
