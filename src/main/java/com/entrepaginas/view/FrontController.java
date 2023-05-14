package com.entrepaginas.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.entrepaginas.model.Book;
import com.entrepaginas.model.Client;
import com.entrepaginas.model.Library;
import com.entrepaginas.model.Users;
import com.entrepaginas.utils.Readers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FrontController implements Initializable {

    private Library library = new Library();
    private Users usersModel = new Users();
    private Book livroSelecionado;
    private Client userSelecionado;
    private Book livroAluguelSelecionado;
    private Client clientAluguelSelecionado;

    //Listagem de Livros
    @FXML private TableColumn<Book,String> bookIsbn;
    @FXML private TableColumn<Book,String> bookAuthor;
    @FXML private TableColumn<Book,String> bookTitle;
    @FXML private TableColumn<Book,String> bookPrice;
    @FXML private TableColumn<Book,String> bookQtd;
    @FXML private TableView<Book> books;

    //Inputs de Livros
    @FXML private TextField inputTitle;
	@FXML private TextField inputAuthor;
    @FXML private TextField inputIsbn;
    @FXML private TextField inputQuantidade;


    //Listagem de CLientes
    @FXML private TableColumn<Users,String> clientId;
    @FXML private TableColumn<Users,String> clientName;
    @FXML private TableColumn<Users,String> clientCpf;
    @FXML private TableColumn<Users,String> clientTelefone;
    @FXML private TableView<Client> users;

    //INPUTS DE CLIENTES
    @FXML private TextField inputName;
	@FXML private TextField inputCpf;
    @FXML private TextField inputTelefone;
    @FXML private TextField inputClientId;


    @FXML private TableView<Book> tableLivroAluguel;
    @FXML private TableView<Client> tableClienteAluguel;
    @FXML private TableColumn<Book,String> columnIdLivro;
    @FXML private TableColumn<Book,String> columnNomeLivro;
    @FXML private TableColumn<Book,String> columnQtdLivro;
    @FXML private TableColumn<Client,String> columnIdCliente;
    @FXML private TableColumn<Client,String> columnNomeCliente;

    @FXML private TextField inputLivroSelected;
	@FXML private TextField inputClienteSelected;



    private ObservableList<Book> livroList = FXCollections.observableArrayList();
    private ObservableList<Client> clientList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        listBookInit();
        listClientInit();
        listBookAluguelInit();
        listClientAluguelInit();
        books.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Book>() {
			@Override
			public void changed(ObservableValue<? extends Book> observable, Book oldValue, Book newValue) {
				livroSelecionado = newValue;
                if(livroSelecionado != null){
                    inputAuthor.setText(livroSelecionado.getAuthor());
                    inputIsbn.setText(livroSelecionado.getIsbn());
                    inputTitle.setText(livroSelecionado.getTitle());
                    inputQuantidade.setText(Integer.toString(livroSelecionado.getQtd()));
                }
			}
        });

        users.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Client>() {
			@Override
			public void changed(ObservableValue<? extends Client> observable, Client oldValue, Client newValue) {
				userSelecionado = newValue;
                if(userSelecionado != null){
                    inputClientId.setText(userSelecionado.getClientId());
                    inputName.setText(userSelecionado.getUsername());
                    inputCpf.setText(userSelecionado.getCpf());
                    inputTelefone.setText(userSelecionado.getPhone());
                }
			}
        });

        tableLivroAluguel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Book>() {
			@Override
			public void changed(ObservableValue<? extends Book> observable, Book oldValue, Book newValue) {
				livroAluguelSelecionado = newValue;
                if(livroAluguelSelecionado != null){
                    inputLivroSelected.setText(livroAluguelSelecionado.getTitle());
                }
			}
        });
        tableClienteAluguel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Client>() {
			@Override
			public void changed(ObservableValue<? extends Client> observable, Client oldValue, Client newValue) {
				clientAluguelSelecionado = newValue;
                if(clientAluguelSelecionado != null){
                    inputClienteSelected.setText(clientAluguelSelecionado.getUsername());
                }
			}
        });

        
    }



    // FUNçÕES DE LIVROS
    public void listBookInit(){
        library = Readers.readFileLibrary("livros.csv");
        bookIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        bookAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        bookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        bookQtd.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        livroList = FXCollections.observableArrayList(library.returnBooks());
        books.setItems(livroList);
    }
    
    public void deleteBook(ActionEvent event){
        library.removeBook(livroSelecionado.getIsbn());
        Readers.writeFileBook("livros.csv", library);
        listBookInit();
    }

    public void addBook(){
        Book newBook = new Book();

        newBook.setAuthor(inputAuthor.getText());
        newBook.setIsbn(inputIsbn.getText());
        newBook.setTitle(inputTitle.getText());

        library.addBook(newBook);
        Readers.writeFileBook("livros.csv", library);
        listBookInit();
    }
    

    public void editBook() {
        Book tempBook = new Book();
        tempBook.setIsbn(inputIsbn.getText());
        tempBook.setAuthor(inputAuthor.getText());
        tempBook.setTitle(inputTitle.getText());
        tempBook.setQtd(Integer.parseInt(inputQuantidade.getText()));
        library.updateBook(livroSelecionado.getIsbn(), tempBook);
        Readers.writeFileBook("livros.csv", library);
        listBookInit();
    }


    public void listClientInit(){
        usersModel = Readers.readFileUsers("Clientes.csv");
        clientId.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        clientName.setCellValueFactory(new PropertyValueFactory<>("username"));
        clientCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        clientTelefone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        clientList = FXCollections.observableArrayList(usersModel.returnClients());
        users.setItems(clientList);
    }

    public void addCliente(){
        Client newClient = new Client();

        newClient.setid(inputClientId.getText());
        newClient.setUsername(inputName.getText());
        newClient.setCpf(inputCpf.getText());
        newClient.setPhone(inputTelefone.getText());
        usersModel.addClient(newClient);
        Readers.writeFileClient("Clientes.csv", usersModel);
        listClientInit();
    }

    public void editCliente(){
        Client newClient = new Client();

        newClient.setid(inputClientId.getText());
        newClient.setUsername(inputName.getText());
        newClient.setCpf(inputCpf.getText());
        newClient.setPhone(inputTelefone.getText());

        usersModel.updateClient(inputClientId.getText(), newClient);
        Readers.writeFileClient("Clientes.csv", usersModel);
        listClientInit();
    }

    public void removeCliente(){
        usersModel.removeClient(inputClientId.getText());
        Readers.writeFileClient("Clientes.csv", usersModel);
        listClientInit();
    }   




    public void listBookAluguelInit(){
        library = Readers.readFileLibrary("livros.csv");
        columnIdLivro.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        columnNomeLivro.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnQtdLivro.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        livroList = FXCollections.observableArrayList(library.returnBooks());
        tableLivroAluguel.setItems(livroList);
    }

    public void listClientAluguelInit(){
        usersModel = Readers.readFileUsers("Clientes.csv");
        columnIdCliente.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        columnNomeCliente.setCellValueFactory(new PropertyValueFactory<>("username"));
        clientList = FXCollections.observableArrayList(usersModel.returnClients());
        tableClienteAluguel.setItems(clientList);
    }

    // public void alugarLivro(){
    //     usersModel.borrowBook(clientAluguelSelecionado.getClientId(), livroAluguelSelecionado.getIsbn(), library);
    //     Readers.writeFileBook("livros.csv", library);
    //     listBookAluguelInit();
    // }

    



}
