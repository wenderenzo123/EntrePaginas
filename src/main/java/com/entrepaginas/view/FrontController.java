package com.entrepaginas.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.entrepaginas.model.Book;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class FrontController implements Initializable {

    @FXML private TableView<Book> books;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }
    
}
