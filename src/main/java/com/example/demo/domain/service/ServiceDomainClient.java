package com.example.demo.domain.service;

import com.example.demo.domain.entity.Client;
import com.example.demo.domain.ports.in.ClientInterfacePortIn;
import com.example.demo.domain.ports.out.ClientInterfacePortOut;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDomainClient implements ClientInterfacePortIn {
    private final ClientInterfacePortOut clientRepository;

    public ServiceDomainClient(ClientInterfacePortOut clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create(Client client) {
    if (clientRepository.existsByIdentification(client.getIdentification())){
        throw new IllegalArgumentException("El cliente con esta identificación ya existe.");
    }
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> getClientById(long id) {
        return clientRepository.getClientById(id);
    }

    @Override
    public Optional<Client> getClientByIdentification(long identification) {
        return clientRepository.getClientByIdentification(identification);
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.getClients();
    }

    @Override
    public void deleteClient(long id) {
        Optional<Client> existingClient = clientRepository.getClientById(id);

        if (existingClient.isPresent()){
            clientRepository.deleteClient(id);
        }else {
            throw new RuntimeException("client not found");
        }

    }

    @Override
    public Client updateClient(long id, Client client) {
        Optional<Client> existingClient = clientRepository.getClientById(id);

        if (existingClient.isPresent()){
            return clientRepository.updateClient(id, client);
        }else {
            throw new RuntimeException("client not found");
        }
    }
}
