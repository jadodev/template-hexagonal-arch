package com.example.demo.domain.ports.out;
import com.example.demo.domain.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientInterfacePortOut {
    Client save(Client Client);
    boolean existsByIdentification(long identification);
    Optional<Client> getClientById(long id);
    Optional<Client> getClientByIdentification(long identification);
    List<Client>getClients();
    void deleteClient(long id);
    Client updateClient(long id, Client client);
}
