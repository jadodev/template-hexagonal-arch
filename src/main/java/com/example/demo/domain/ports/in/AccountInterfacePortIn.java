package com.example.demo.domain.ports.in;

import com.example.demo.domain.entity.Account;
import com.example.demo.domain.entity.Client;

import java.util.Optional;

public interface AccountInterfacePortIn {
    Account create(Account account);
    Optional<Account> getAccountById(long id);
    void deleteAccount(long id);
    Account updateAccount(long id, Account account);
}
