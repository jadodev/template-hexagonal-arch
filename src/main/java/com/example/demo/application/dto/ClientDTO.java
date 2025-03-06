package com.example.demo.application.dto;

import com.example.demo.domain.type.AccountType;

public class ClientDTO {
    private long identification;
    private String name;
    private String lastname;
    private AccountType type;

    public ClientDTO(long identification, String name, String lastname, AccountType type){
        this.identification = identification;
        this.name = name;
        this.lastname = lastname;
        this.type = type;
    }

    public long getIdentification() {
        return identification;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setIdentification(long identification) {
        this.identification = identification;
    }

    public AccountType getType() {
        return type;
    }
}
