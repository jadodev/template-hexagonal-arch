package com.example.demo.domain.service;

import com.example.demo.domain.entity.Account;
import com.example.demo.domain.ports.in.AccountInterfacePortIn;
import com.example.demo.domain.ports.out.AccountInterfacePortOut;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceDomain implements AccountInterfacePortIn {
    private final AccountInterfacePortOut repository;

    public AccountServiceDomain(AccountInterfacePortOut repository) {
        this.repository = repository;
    }

    @Override
    public Account create(Account account) {
        return repository.save(account);
    }

    @Override
    public Optional<Account> getAccountbyIdUser(long userId) {
        return Optional.ofNullable(repository.getAccountByIdUser(userId));
    }
}
