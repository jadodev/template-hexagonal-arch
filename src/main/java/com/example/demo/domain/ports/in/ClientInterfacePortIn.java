package com.example.demo.domain.ports.in;

import com.example.demo.domain.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientInterfacePortIn {
    Client create(Client client);
    Optional<Client> getClientById(long id);
    Optional<Client> getClientByIdentification(long identification);
    List<Client> getClients();
    void deleteClient(long id);
    Client updateClient(long id, Client client);
}
