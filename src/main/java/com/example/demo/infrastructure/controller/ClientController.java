package com.example.demo.infrastructure.controller;

import com.example.demo.application.dto.ClientDTO;
import com.example.demo.application.service.ClientServiceApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientServiceApplication clientServiceApp;

    public ClientController(ClientServiceApplication clientServiceApp) {
        this.clientServiceApp = clientServiceApp;
    }

    @PostMapping("/new")
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientDTO){
        ClientDTO client = clientServiceApp.create(clientDTO);
        System.out.println("Created successfull");
        return ResponseEntity.ok(client);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") long id ){
        Optional<ClientDTO> clientDTO = clientServiceApp.getClientById(id);
        if (clientDTO.isPresent()){
            return ResponseEntity.ok(clientDTO.get());
        }else {
            throw new RuntimeException("Internal Server Error");
        }
    }

    @GetMapping("/clients")
    public ResponseEntity<List> getClients(){
        return ResponseEntity.ok(clientServiceApp.getClients());
    }

    @GetMapping("/id/{identification}")
    public ResponseEntity<ClientDTO> getClientByIdentification(@PathVariable("identification") long identification) {
        return clientServiceApp.getClientByIdentification(identification)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable("id") long id, @RequestBody ClientDTO clientDTO ){
        Optional<ClientDTO> client = clientServiceApp.getClientById(id);
        if (client.isPresent()){
            ClientDTO updateClient = clientServiceApp.update(id,clientDTO);
            return ResponseEntity.ok(updateClient);
        }else {
            throw new RuntimeException("Internal Server Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        try {
            clientServiceApp.delete(id);
            return ResponseEntity.ok("Client deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
    }
}

















