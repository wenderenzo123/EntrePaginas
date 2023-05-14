package com.entrepaginas.model;

public class Rent {


    private String rentId;
    private String isbn;
    private String clientId;
    private String clientName;
    private String livro;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    
    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public Rent(String rentId, String isbn, String livro, String clientId, String clientName) {
        this.isbn = isbn;
        this.clientName = clientName;
        this.livro = livro;
        this.rentId = rentId;
        this.clientId = clientId;
    }

    public Rent() {
        this.isbn = "";
        this.clientName = "";
        this.livro = "";
        this.rentId = "";
        this.clientId = "";
    }

    public String toString() {
        return isbn + "," + clientName + "," + livro;
    }
}
