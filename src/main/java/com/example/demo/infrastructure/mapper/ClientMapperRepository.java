package com.example.demo.infrastructure.mapper;

import com.example.demo.domain.entity.Client;
import com.example.demo.infrastructure.entity.ClientEntityRepository;

public class ClientMapperRepository {
    public static ClientEntityRepository toEntity(Client client) {
        ClientEntityRepository clientEntity = new ClientEntityRepository();
        clientEntity.setIdentification(client.getIdentification());
        clientEntity.setName(client.getName());
        clientEntity.setLastname(client.getLastname());
        return clientEntity;
    }

    public static Client toDomain(ClientEntityRepository clientEntity) {
        Client client = new Client(clientEntity.getIdentification(), clientEntity.getName(), clientEntity.getLastname());
        return client;
    }
}
