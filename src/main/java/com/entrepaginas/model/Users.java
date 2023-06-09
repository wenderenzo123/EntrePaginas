package com.entrepaginas.model;

import java.util.ArrayList;
import java.util.Stack;



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
            if (client.getClientId().equals(id)) {
                return client;
            }
        }
        return null;
    }

    public String voltarAoHistorico() {
        return this.historico.pop();
    }

    public void historicoGeral() {
        for (String string : historico) {
            System.out.println(string);
        }
    }

    public void borrowBook(String id, String isbn3 , Library library) {
        Client client = findClient(id);
        Book book = library.findBook(isbn3);
        if (book.getQtd()>0) {
            historico.push("O livro " + book.getTitle() + " foi emprestado para " + client.getUsername());
        } else {
            historico.push("O livro " + book.getTitle() + " não está disponível");
        }
    }

    public ArrayList<Client> returnClients() {
        return clients;
    }

    public void ListaDeClientes() {
        for (Client client : clients) {
            System.out.println(client.getClientId() + " - " + client.getUsername() + " - " + client.getPhone() + " - " + client.getCpf());
        }
    }

    public void removeClient(String clientId) {
        Client client = findClient(clientId);
        clients.remove(client);
    }

    public void updateClient(String id3, Client client) {
        Client client2 = findClient(id3);
        client2.setUsername(client.getUsername());
        client2.setCpf(client.getCpf());
        client2.setPhone(client.getPhone());

        clients.set(clients.indexOf(client2), client2);
    }
}

