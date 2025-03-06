package com.example.demo.infrastructure.mapper;

import com.example.demo.domain.entity.Account;
import com.example.demo.infrastructure.entity.AccountEntity;
import com.example.demo.infrastructure.entity.ClientEntity;

public class AccountMapperRepository {

    public static Account toDomain(AccountEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Account(
                entity.getUser().getIdentification(),
                entity.getName(),
                entity.getLastname(),
                entity.getType()
        );
    }

    public static AccountEntity toEntity(Account domain, ClientEntity clientEntity) {
        if (domain == null || clientEntity == null) {
            return null;
        }
        return new AccountEntity(
                domain.getNumber(),
                clientEntity,
                domain.getName(),
                domain.getLastname(),
                domain.getType(),
                domain.getAmount(),
                domain.getSecurityNumber()
        );
    }
}
