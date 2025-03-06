package com.example.demo.infrastructure.entity;

import com.example.demo.domain.type.AccountType;
import jakarta.persistence.*;

@Entity
@Table(name = "clients", uniqueConstraints = {@UniqueConstraint(columnNames = "identification")})
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private long identification;

    private String name;

    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private AccountEntity account;

    public ClientEntity() {}

    public ClientEntity(long identification, String name, String lastName, AccountType accountType) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.accountType = accountType;
    }

    public void setAccount(AccountEntity account) {
        if (account == null) {
            if (this.account != null) {
                this.account.setUser(null);
            }
        } else {
            account.setUser(this);
        }
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public long getIdentification() {
        return identification;
    }

    public void setIdentification(long identification) {
        this.identification = identification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

}
