package com.example.demo.infrastructure.repository;

import com.example.demo.domain.entity.Account;
import com.example.demo.domain.entity.Client;
import com.example.demo.domain.ports.out.AccountInterfacePortOut;
import com.example.demo.infrastructure.entity.AccountEntity;
import com.example.demo.infrastructure.entity.ClientEntity;
import com.example.demo.infrastructure.mapper.AccountMapperRepository;
import com.example.demo.infrastructure.mapper.ClientMapperRepository;
import org.springframework.stereotype.Repository;


@Repository
public class AccountRepository implements AccountInterfacePortOut {
    private final AccountRepositoryJpa repositoryJpa;
    private  final ClientRepository clientRepository;

    public AccountRepository(AccountRepositoryJpa repositoryJpa, ClientRepository clientRepository) {
        this.repositoryJpa = repositoryJpa;
        this.clientRepository = clientRepository;
    }

    @Override
    public Account save(Account account) {
        Client client = clientRepository.getClientByIdentification(account.getUserId())
                .orElseThrow(()-> new RuntimeException("cliente no encontrado"));

        ClientEntity clientEntity = ClientMapperRepository.toEntity(client);

        AccountEntity newAccount = AccountMapperRepository.toEntity(account, clientEntity);
        return  AccountMapperRepository.toDomain(repositoryJpa.save(newAccount));
    }

    @Override
    public Account getAccountByIdUser(long userId) {
        return repositoryJpa.findByUser_Identification(userId)
                .map(AccountMapperRepository::toDomain)
                .orElse(null);
    }
}
