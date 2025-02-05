package com.example.demo.infrastructure.repository;

import com.example.demo.infrastructure.entity.ClientEntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepositoryJpa extends JpaRepository<ClientEntityRepository, Long> {
        Optional<ClientEntityRepository> findByIdentification(long identification);
        boolean existsByIdentification(long identification);
}
