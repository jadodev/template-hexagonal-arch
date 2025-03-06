package com.example.demo.application.mapper;

import com.example.demo.application.dto.AccountDTO;
import com.example.demo.domain.entity.Account;

public class AccountMapper {
    public static AccountDTO toDTO(Account account) {
        return new AccountDTO(
                account.getUserId(),
                account.getNumber(),
                account.getName(),
                account.getLastname(),
                account.getType(),
                account.getAmount(),
                account.getSecurityNumber());
    }

    public static Account toEntity(AccountDTO accountDTO) {
        Account account = new Account(
                accountDTO.getUserId(),
                accountDTO.getName(),
                accountDTO.getLastname(),
                accountDTO.getType()
        );

        account.setNumber(account.getNumber());
        account.setAmount(accountDTO.getAmount());

        return  account;
    }
}
