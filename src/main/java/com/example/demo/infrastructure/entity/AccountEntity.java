package com.example.demo.infrastructure.entity;

import com.example.demo.domain.type.AccountType;
import jakarta.persistence.*;

@Entity
@Table(name = "accounts", uniqueConstraints = {@UniqueConstraint(columnNames = "number")})
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "identification", nullable = false)
    private ClientEntity user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType type;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private int securityNumber;

    public AccountEntity() {}

    public AccountEntity(String number, ClientEntity user, String name, String lastname, AccountType type, double amount, int securityNumber) {
        this.number = number;
        this.user = user;
        this.name = name;
        this.lastname = lastname;
        this.type = type;
        this.amount = amount;
        this.securityNumber = securityNumber;
    }

    public void setUser(ClientEntity user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public ClientEntity getUser() {
        return user;
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
}
