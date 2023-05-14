package com.entrepaginas;

import com.entrepaginas.model.Book;
import com.entrepaginas.model.Client;
import com.entrepaginas.model.Library;
import com.entrepaginas.model.Users;
import com.entrepaginas.utils.File;
import com.entrepaginas.utils.Readers;

public class App {

    public static void main(String[] args) {

        String ArqBooks = "livros.csv";
        String ArqClient = "Clientes.csv";

        Library library = new Library();
        Users users = new Users();
        users = Readers.readFileUsers(ArqClient);
        library = Readers.readFileLibrary(ArqBooks);
        System.out.println("Livros cadastrados: ");
        while (true) {
            menu();
            int opcao = Integer.parseInt(System.console().readLine());
            switch (opcao) {
                case 1:
                    Book book = new Book();
                    System.out.println("Digite o título do livro: ");
                    book.setTitle(System.console().readLine());
                    System.out.println("Digite o autor do livro: ");
                    book.setAuthor(System.console().readLine());
                    System.out.println("Digite o ISBN do livro: ");
                    book.setIsbn(System.console().readLine());
                    library.addBook(book);
                    break;
                case 2:
                    library.printBooks();
                    break;
                case 3:
                    System.out.println("Digite o ISBN do livro a ser removido: ");
                    String isbn = System.console().readLine();
                    library.removeBook(isbn);
                    break;
                case 4:
                    System.out.println("Digite o ISBN do livro a ser atualizado: \n");
                    String isbn2 = System.console().readLine();
                    System.out.println("Digite o Novo Titulo do livro: ");
                    String title = System.console().readLine();
                    System.out.println("Digite o Novo Autor do livro: ");
                    String author = System.console().readLine();
                    System.out.println("Digite a Nova Quantidade do livro: ");
                    int qtd = Integer.parseInt(System.console().readLine());
                    Book book2 = new Book(title, author, isbn2, qtd);
                    library.updateBook(isbn2,book2);
                    break;
                case 5:
                    System.out.println("Digite o ISBN do livro a ser emprestado: ");
                    String isbn3 = System.console().readLine();
                    System.out.println("Digite o ID do cliente: ");
                    String id = System.console().readLine();
                    users.borrowBook(id, isbn3, library);
                    library.borrowBook(isbn3);
                    break;
                case 6:
                    System.out.println("Digite o ISBN do livro a ser devolvido: ");
                    String isbn4 = System.console().readLine();
                    library.returnBook(isbn4);
                    break;
                case 7:
                    library.printAvailableBooks();
                    break;
                case 8:
                    users.historicoGeral();
                    break;
                case 9:
                    System.out.println("Lista de clientes: ");
                    users.ListaDeClientes();
                    break;
                case 10:
                    System.out.println("Digite o ID do cliente: ");
                    String id2 = System.console().readLine();
                    System.out.println(users.findClient(id2));
                    break;
                case 11:
                    System.out.println("Digite o ID do cliente a ser atualizado: ");
                    String id3 = System.console().readLine();
                    System.out.println("Digite o Novo Nome do cliente: ");
                    String nome = System.console().readLine();
                    System.out.println("Digite o Novo CPF do cliente: ");
                    String cpf = System.console().readLine();
                    System.out.println("Digite o Novo Telefone do cliente: ");
                    String telefone = System.console().readLine();
                    Client client = new Client(nome, id3, cpf, telefone);
                    users.updateClient(id3, client);
                    break;
                case 12:
                    System.out.println("Digite o ID do cliente a ser removido: ");
                    String id4 = System.console().readLine();
                    users.removeClient(id4);
                    break;
                case 0:
                    System.exit(0);
                    // Atualizando a base de Livros
                    // writeFileBook(ArqBooks, library);
                    // Atualizando a base de Clientes
                    // writeFileClient(ArqClient, users);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Remover livro");
        System.out.println("4 - Atualizar livro");
        System.out.println("5 - Emprestar livro");
        System.out.println("6 - Devolver livro");
        System.out.println("7 - Livros disponíveis");
        System.out.println("8 - Histotico de emprestimos");
        System.out.println("9 - Lista de clientes");
        System.out.println("10 - Buscar Cliente");
        System.out.println("11 - Atualizar Cliente");
        System.out.println("12 - Remover Cliente");
        System.out.println("0 - Sair");
        System.out.println("Digite a opção desejada: ");
    }

    public static Library readFileLibrary(String path) {
        String conteudo = File.Read(path);
        System.out.println(conteudo);
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
        System.out.println(conteudo);
        Users users = new Users();
        for (String string : conteudo.split(";")) {
            Client client = new Client();
            client.setid(string.split(",")[0]);
            client.setUsername(string.split(",")[1]);
            client.setPhone(string.split(",")[3]);
            users.addClient(client);
        }
        return users;
    }

    public static void writeFileBook(String path, Library library) {
        File.Write(path, library.returnBooks(),1);
    }

    public static void writeFileClient(String path, Users users) {
        File.Write(path, users.returnClients(),2);
    }
}