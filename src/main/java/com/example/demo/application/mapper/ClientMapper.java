package com.example.demo.application.mapper;

import com.example.demo.application.dto.ClientDTO;
import com.example.demo.domain.entity.Client;

public class ClientMapper {
    public static ClientDTO toDto (Client client){
        return new ClientDTO(
                client.getIdentification(),
                client.getName(),
                client.getLastname(),
                client.getAccount().getType());
    }

    public static Client toEntity (ClientDTO clientDto){
        Client client = new Client(
                clientDto.getIdentification(),
                clientDto.getName(),
                clientDto.getLastname(),
                clientDto.getType());
        return client;
    }
}
