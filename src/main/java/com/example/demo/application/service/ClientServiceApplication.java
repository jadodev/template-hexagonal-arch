package com.example.demo.application.service;

import com.example.demo.application.dto.AccountDTO;
import com.example.demo.application.dto.ClientDTO;
import com.example.demo.application.mapper.ClientMapper;
import com.example.demo.domain.entity.Client;
import com.example.demo.domain.ports.in.ClientInterfacePortIn;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceApplication {
    private final ClientInterfacePortIn clientInterfacePortIn;
    private final AccountApplicationService accountService;
    private AccountDTO accountDTO;

    public ClientServiceApplication(ClientInterfacePortIn clientInterfacePortIn, AccountApplicationService accountService) {
        this.clientInterfacePortIn = clientInterfacePortIn;
        this.accountService = accountService;
    }

    public ClientDTO create(ClientDTO clientDto){
        try {
            Client newClient = ClientMapper.toEntity(clientDto);
            Client savedClient = clientInterfacePortIn.create(newClient);

            AccountDTO accountDTO = new AccountDTO(
                    savedClient.getIdentification(),
                    savedClient.getAccount().getNumber(),
                    savedClient.getName(),
                    savedClient.getLastname(),
                    savedClient.getAccount().getType(),
                    savedClient.getAccount().getAmount(),
                    savedClient.getAccount().getSecurityNumber()
            );

            accountService.create(accountDTO);

            return ClientMapper.toDto(savedClient);

        } catch (Exception e){
            throw new RuntimeException("Error creating client", e);
        }
    }

    public Optional<ClientDTO> getClientById(long id){
        Optional<Client> findClient = clientInterfacePortIn.getClientById(id);
        if (findClient.isPresent()){
            return Optional.of(ClientMapper.toDto(findClient.get()));
        } else {
            throw new RuntimeException("Client not found");
        }
    }

    public Optional<ClientDTO> getClientByIdentification(long identification) {
        return clientInterfacePortIn.getClientByIdentification(identification)
                .map(ClientMapper::toDto);
    }

    public List<ClientDTO> getClients(){
        List<Client> listClients = clientInterfacePortIn.getClients();
        return listClients.stream()
                .map(client -> ClientMapper.toDto(client))
                .collect(Collectors.toList());
    }

    public ClientDTO update(long id, ClientDTO clientDTO){
        Optional<Client> findClient = clientInterfacePortIn.getClientById(id);
        if (!findClient.isPresent()){
            throw new RuntimeException("Client not found");
        }

        Client client = findClient.get();

        client.setName(clientDTO.getName());
        client.setLastname(clientDTO.getLastname());

        Client updatedClient = clientInterfacePortIn.updateClient(id,client);
        return ClientMapper.toDto(updatedClient);
    }

    public void delete(long id){
       Optional<Client> findClient = clientInterfacePortIn.getClientById(id);
       if (findClient.isPresent()){
           clientInterfacePortIn.deleteClient(id);
       }else {
           throw  new RuntimeException("client not found");
       }
    }
}













