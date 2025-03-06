package com.example.demo.infrastructure.repository;

import com.example.demo.infrastructure.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepositoryJpa extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByUser_Identification(long userId);
}
