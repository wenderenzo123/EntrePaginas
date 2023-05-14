package com.entrepaginas.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.entrepaginas.model.Book;
import com.entrepaginas.model.Library;
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
    // private Users users = new Users();
    private Book livroSelecionado;

    //Listagem de Livros
    @FXML private TableColumn<Book,String> bookIsbn;
    @FXML private TableColumn<Book,String> bookAuthor;
    @FXML private TableColumn<Book,String> bookTitle;
    @FXML private TableColumn<Book,String> bookPrice;
    @FXML private TableView<Book> books;

    //Inputs de Livros
    @FXML private TextField inputTitle;
	@FXML private TextField inputAuthor;
    @FXML private TextField inputIsbn;
    @FXML private TextField inputQuantidade;


    private ObservableList<Book> livroList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        listBookInit();
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
			}});
    }




    public void listBookInit(){
        library = Readers.readFileLibrary("livros.csv");
        bookIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        bookAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        bookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        // bookPrice.setCellValueFactory(new PropertyValueFactory<>("valor"));
        // System.out.println(library.returnBooks());
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
}
