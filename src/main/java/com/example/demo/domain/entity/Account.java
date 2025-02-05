package com.example.demo.domain.entity;

public class Account {
  private long id;
  private String type;
  private String number;
  private Double amounth;
  private Client client;

  public Account(long id, String type, Double amounth, Client client){
      this.id = id;
      this.client = client;
      this.type = type;
      this.number = generateAccountNumber();
      this.amounth = amounth;
  }

    private String generateAccountNumber(){
      return String.format("%012d", id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        this.number = generateAccountNumber();
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
