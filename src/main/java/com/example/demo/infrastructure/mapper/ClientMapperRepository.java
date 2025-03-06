package com.example.demo.infrastructure.mapper;

import com.example.demo.domain.entity.Client;
import com.example.demo.infrastructure.entity.ClientEntity;

public class ClientMapperRepository {

    public static ClientEntity toEntity(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setIdentification(client.getIdentification());
        clientEntity.setName(client.getName());
        clientEntity.setLastName(client.getLastname());
        clientEntity.setAccountType(client.getAccount().getType());
        return clientEntity;
    }

    public static Client toDomain(ClientEntity clientEntity) {
        Client client = new Client(
                clientEntity.getIdentification(),
                clientEntity.getName(),
                clientEntity.getLastName(),
                clientEntity.getAccountType()
        );
        return client;
    }
}
