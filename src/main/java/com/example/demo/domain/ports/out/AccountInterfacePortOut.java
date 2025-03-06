package com.example.demo.domain.ports.out;

import com.example.demo.domain.entity.Account;

public interface AccountInterfacePortOut {
    Account save(Account account);
    Account getAccountByIdUser(long userIs);
}
