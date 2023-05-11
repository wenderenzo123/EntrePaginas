package com.entrepaginas;

import com.entrepaginas.model.Book;
import com.entrepaginas.model.Library;
import com.entrepaginas.model.Users;
import com.entrepaginas.utils.File;
import com.entrepaginas.utils.Readers.*;

public class App {

    public static void main(String[] args) {

        String ArqBooks = "livros.csv";
        String ArqClient = "Clientes.csv";

        Library library = new Library();
        Users users = new Users();
        // users = Readers.readFileUsers(ArqClient);
        // library = Readers.readFileLibrary(ArqBooks);
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
                    library.updateBook(isbn2, title);
                    break;
                case 5:
                    System.out.println("Digite o ISBN do livro a ser emprestado: ");
                    String isbn3 = System.console().readLine();
                    System.out.println("Digite o ID do cliente: ");
                    String id = System.console().readLine();
                    users.borrowBook(id, isbn3);
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
        System.out.println("0 - Sair");
        System.out.println("Digite a opção desejada: ");
    }
}