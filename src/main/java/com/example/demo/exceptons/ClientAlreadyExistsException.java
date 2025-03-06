package com.example.demo.exceptons;

public class ClientAlreadyExistsException extends RuntimeException {
    public  ClientAlreadyExistsException( String message){
        super(message);
    }
}
