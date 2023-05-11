package com.entrepaginas.model;

import java.util.Stack;

import com.entrepaginas.utils.ArrayList;


public class Users {
    private Stack<String> historico;
    private ArrayList<Client> clients;
    
    public Users() {
        this.historico = new Stack<>();
        this.clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public Client findClient(String id) {
        for (Client client : clients) {
            if (client.getid().equals(id)) {
                return client;
            }
        }
        return null;
    }

    public String voltarAoHistorico() {
        return this.historico.pop();
    }

    public void borrowBook(String id, String isbn3) {
        Client client = findClient(id);
        Library library = new Library();
        Book book = library.findBook(isbn3);
        if (book.isAvailable()) {
            book.setAvailable(false);
            client.setBook(book.getIsbn());
            historico.push("O livro " + book.getTitle() + " foi emprestado para " + client.getUsername());
        } else {
            historico.push("O livro " + book.getTitle() + " não está disponível");
        }
    }

    public ArrayList<Client> returnClients() {
        return clients;
    }
}

