package com.entrepaginas.model;

public class Client {
    private String username;
    private String id;
    private String email;
    private String phone;
    private String book;

    
    public Client(String username, String id, String email, String phone, String book) {
        this.username = username;
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.book = book;
    }

    public Client() {
        this.username = "";
        this.id = "";
        this.email = "";
        this.phone = "";
        this.book = "";
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getid() {
        return id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public void setid(String id) {
        this.id= id;
    }
    public void setEmail(String email) {
        this.email= email;
    }
    public String getBook() {
        return book;
    }
    
    public void setBook(String book) {
        this.book = book;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
