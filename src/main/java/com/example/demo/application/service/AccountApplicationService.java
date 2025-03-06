package com.example.demo.application.service;

import com.example.demo.application.dto.AccountDTO;
import com.example.demo.application.mapper.AccountMapper;
import com.example.demo.domain.entity.Account;
import com.example.demo.domain.service.AccountServiceDomain;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountApplicationService {
    private final AccountServiceDomain service;

    public AccountApplicationService(AccountServiceDomain service) {
        this.service = service;
    }

    public AccountDTO create (AccountDTO accountDTO){
        Account account = AccountMapper.toEntity(accountDTO);
        Account createdAccount = service.create(account);
        return AccountMapper.toDTO(createdAccount);
    }

    public Optional<AccountDTO> getAccount(long userId) {
        return service.getAccountbyIdUser(userId)
                .map(AccountMapper::toDTO);
    }
}
