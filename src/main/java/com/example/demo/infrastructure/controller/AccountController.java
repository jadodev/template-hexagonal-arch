package com.example.demo.infrastructure.controller;

import com.example.demo.application.dto.AccountDTO;
import com.example.demo.application.dto.ClientDTO;
import com.example.demo.application.service.AccountApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController()
@RequestMapping("/account")
public class AccountController {
    private final AccountApplicationService service;

    public AccountController(AccountApplicationService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public AccountDTO getAccount(@PathVariable("userId") long userId) {
        return service.getAccount(userId)
                .orElseThrow(() -> new RuntimeException("Internal Server Error"));
    }

}
