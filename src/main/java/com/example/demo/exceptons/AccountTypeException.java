package com.example.demo.exceptons;

public class AccountTypeException extends RuntimeException{
    public  AccountTypeException(String message){
        super(message);
    }
}
