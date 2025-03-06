package com.example.demo.infrastructure.controller;

import com.example.demo.exceptons.AccountTypeException;
import com.example.demo.exceptons.AmountException;
import com.example.demo.exceptons.ClientAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleClientAlreadyExistsException(ClientAlreadyExistsException ex){
        Map<String,Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        response.put("status", HttpStatus.CONFLICT.value());
        response.put("error", "conflict");

        return  new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AccountTypeException.class)
    public ResponseEntity<Map<String, Object>> handleAccountTypeException(AccountTypeException ex){
        Map<String,Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        response.put("status", HttpStatus.CONFLICT.value());
        response.put("error", "conflict");

        return  new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AmountException.class)
    public ResponseEntity<Map<String, Object>> handleAmountException(AmountException ex){
        Map<String,Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        response.put("status", HttpStatus.CONFLICT.value());
        response.put("error", "conflict");

        return  new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }
}
