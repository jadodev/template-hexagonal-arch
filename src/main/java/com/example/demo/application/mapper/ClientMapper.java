package com.example.demo.application.mapper;

import com.example.demo.application.dto.AccountDTO;
import com.example.demo.application.dto.ClientDTO;
import com.example.demo.domain.entity.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {
    public static ClientDTO toDto (Client client){
//        List<AccountDTO> accountDtos = client.getAccounts().stream()
//                .map(account -> new AccountDTO(account.getType(), account.getAmounth(), account.getNumber()))
//                .collect(Collectors.toList());

        return new ClientDTO(client.getIdentification(), client.getName(), client.getLastname());
    }

    public static Client toEntity (ClientDTO clientDto){
        return new Client(clientDto.getIdentification(), clientDto.getName(), clientDto.getLastname());
    }
}
