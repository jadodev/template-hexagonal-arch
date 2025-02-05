package com.example.demo.application.dto;


public class AccountDTO {
    private String type;
    private String number;
    private Double amounth;

    public AccountDTO(String type, Double amounth, String number){
        this.type = type;
        this.amounth = amounth;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public Double getAmounth() {
        return amounth;
    }

    public void setAmounth(Double amounth) {
        this.amounth = amounth;
    }

}
