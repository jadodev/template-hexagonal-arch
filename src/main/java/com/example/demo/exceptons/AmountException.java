package com.example.demo.exceptons;

public class AmountException extends  RuntimeException{
    public AmountException(String message){
        super(message);
    }
}
