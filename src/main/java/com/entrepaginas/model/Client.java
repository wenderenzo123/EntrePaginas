package com.entrepaginas.model;

public class Client {
    private String clientId;
    private String username;
    private String cpf;
    private String phone;

    
    public Client(String username, String clientId, String cpf, String phone) {
        this.username = username;
        this.clientId = clientId;
        this.cpf = cpf;
        this.phone = phone;
    }

    public Client() {
        this.username = "";
        this.clientId = "";
        this.cpf = "";
        this.phone = "";
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getClientId() {
        return clientId;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public void setid(String clientId) {
        this.clientId= clientId;
    }
    public void setCpf(String cpf) {
        this.cpf= cpf;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.clientId + " - " + this.username + " - " + this.cpf + " - " + this.phone;
    }
}
