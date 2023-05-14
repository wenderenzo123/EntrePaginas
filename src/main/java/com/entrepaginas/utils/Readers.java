package com.entrepaginas.utils;

import com.entrepaginas.model.Book;
import com.entrepaginas.model.Client;
import com.entrepaginas.model.Library;
import com.entrepaginas.model.Rent;
import com.entrepaginas.model.Rents;
import com.entrepaginas.model.Users;

public class Readers {
    
    public static Library readFileLibrary(String path) {
        String conteudo = File.Read(path);
        Library library = new Library();
        for (String string : conteudo.split(";")) {
            Book book = new Book();
            book.setTitle(string.split(",")[0]);
            book.setAuthor(string.split(",")[1]);
            book.setIsbn(string.split(",")[2]);
            book.setQtd(Integer.parseInt(string.split(",")[3]));
            library.addBook(book);
        }
        return library;
    }
    public static Users readFileUsers(String path) {
        String conteudo = File.Read(path);
        Users users = new Users();
        for (String string : conteudo.split(";")) {
            Client client = new Client();
            client.setid(string.split(",")[0]);
            client.setUsername(string.split(",")[1]);
            client.setCpf(string.split(",")[2]);
            client.setPhone(string.split(",")[3]);
            users.addClient(client);
        }
        return users;
    }

    public static Rents readFileRent(String path) {
        String conteudo = File.Read(path);
        System.out.println(conteudo);
        Rents rents = new Rents();
        for (String string : conteudo.split(";")) {
            Rent rent = new Rent();
            rent.setRentId(string.split(",")[0]);
            rent.setIsbn(string.split(",")[1]);
            rent.setLivro(string.split(",")[2]);
            rent.setClientId(conteudo.split(",")[3]);
            rent.setClientName(string.split(",")[4]);
            rents.addRent(rent);
        }
        return rents;

    }
    
    public static void writeFileBook(String path, Library library) {
        File.Write(path, library.returnBooks(), 1);
    }
    
    public static void writeFileClient(String path, Users users) {
        File.Write(path, users.returnClients(), 2);
    }

    public static void writeFileRent(String path, Rents rents) {
        File.Write(path, rents.returnRents(), 3);
    }

}
