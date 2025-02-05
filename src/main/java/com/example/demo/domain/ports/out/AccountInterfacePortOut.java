package com.example.demo.domain.ports.out;

import com.example.demo.domain.entity.Account;

import java.util.Optional;

public interface AccountInterfacePortOut {
    Account save(Account account);
    Optional<Account> getAccountById(long id);
    void deleteAccount(long id);
    Account updateAccount(long id, Account account);
}
