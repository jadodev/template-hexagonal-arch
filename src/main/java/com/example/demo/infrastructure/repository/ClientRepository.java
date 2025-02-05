package com.example.demo.infrastructure.repository;

import com.example.demo.application.dto.ClientDTO;
import com.example.demo.domain.entity.Client;
import com.example.demo.domain.ports.out.ClientInterfacePortOut;
import com.example.demo.infrastructure.entity.ClientEntityRepository;
import com.example.demo.infrastructure.mapper.ClientMapperRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClientRepository implements ClientInterfacePortOut{
    private final ClientRepositoryJpa clientRepository;

    public ClientRepository(ClientRepositoryJpa clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        ClientEntityRepository clientEntity = ClientMapperRepository.toEntity(client);
        return ClientMapperRepository.toDomain(clientRepository.save(clientEntity));
    }

    @Override
    public boolean existsByIdentification(long identification) {
        return clientRepository.existsByIdentification(identification);
    }

    @Override
    public Optional<Client> getClientById(long id) {
        return clientRepository.findById(id).map(ClientMapperRepository::toDomain);
    }

    @Override
    public Optional<Client> getClientByIdentification(long identification) {
        return clientRepository.findByIdentification(identification)
                .map(ClientMapperRepository::toDomain);
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll().stream()
                .map(ClientMapperRepository::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteClient(long id) {
        if (!clientRepository.existsById(id)){
            throw new RuntimeException("Client not found");
        }

        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(long id, Client client) {
       return clientRepository.findById(id)
               .map(existingClientEntity -> {
                   Client existingClient = ClientMapperRepository.toDomain(existingClientEntity);

                   existingClient.setName(client.getName());
                   existingClient.setLastname(client.getLastname());

                   ClientEntityRepository updateEntity =  ClientMapperRepository.toEntity(existingClient);
                   return ClientMapperRepository.toDomain(clientRepository.save(updateEntity));
               })
               .orElseThrow(()-> new RuntimeException("Client not found"));
    }
}



























