package com.example.demo.infrastructure.repository;

import com.example.demo.infrastructure.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepositoryJpa extends JpaRepository<ClientEntity, Long> {
        Optional<ClientEntity> findByIdentification(long identification);
        boolean existsByIdentification(long identification);
}
