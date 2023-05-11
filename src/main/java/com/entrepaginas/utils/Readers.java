package com.entrepaginas.utils;

import com.entrepaginas.model.Book;
import com.entrepaginas.model.Client;
import com.entrepaginas.model.Library;
import com.entrepaginas.model.Users;

public class Readers {
    
    public static Library readFileLibrary(String path) {
        String conteudo = File.Read(path);
        System.out.println(conteudo);
        Library library = new Library();
        for (String string : conteudo.split(";")) {
            Book book = new Book();
            book.setTitle(string.split(",")[0]);
            book.setAuthor(string.split(",")[1]);
            book.setIsbn(string.split(",")[2]);
            book.setAvailable(Boolean.parseBoolean(string.split(",")[3]));
            library.addBook(book);
        }
        return library;
    }
    public static Users readFileUsers(String path) {
        String conteudo = File.Read(path);
        System.out.println(conteudo);
        Users users = new Users();
        for (String string : conteudo.split(";")) {
            Client client = new Client();
            client.setid(string.split(",")[0]);
            client.setUsername(string.split(",")[1]);
            client.setEmail(string.split(",")[2]);
            client.setPhone(string.split(",")[3]);
            client.setBook(string.split(",")[4]);
            users.addClient(client);
        }
        return users;
    }

}
