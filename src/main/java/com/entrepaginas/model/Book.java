package com.entrepaginas.model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int qtd;

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Book(String title, String author, String isbn, int qtd) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.qtd = qtd;
    }

    public Book() {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.qtd = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author= author;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")" + " (Quantidade disponivel: " + qtd + ")";
    }

    public void setIsbn(String string) {
        this.isbn = string;
    }
}
