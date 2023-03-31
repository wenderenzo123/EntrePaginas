package com.entrepaginas;

import com.entrepaginas.model.Library;
import com.entrepaginas.model.Book;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();


        String filename = "livros.txt";
        try {
            FileWriter writer = new FileWriter(filename);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write("Livros na Biblioteca:\n");

            // Criando instâncias da classe Book dinamicamente
            Book livro1 = new Book("Cem Anos de Solidão", "Gabriel Garcia Marquez", "1000001");
            Book livro2 = new Book("1984", "George Orwell", "1000002");
            Book livro3 = new Book("A Montanha Mágica", "Thomas Mann", "1000003");

            // Escrevendo livros no arquivo
            buffer.write(livro1.toString() + "\n");
            buffer.write(livro2.toString() + "\n");
            buffer.write(livro3.toString() + "\n");

            buffer.close();
            System.out.println("Livros adicionados ao arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao adicionar livros ao arquivo.");
            e.printStackTrace();
        }

    }

}