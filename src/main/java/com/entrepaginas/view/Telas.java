package com.entrepaginas.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {

    public static void main(String[] args) {
		launch(args);
	}

    private static Stage primaryStage;
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}

    public static void telaInicial() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("primary.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}

    public static void telaClientes() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaClientes.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}

    public static void telaLocacao() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telaLocacao.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	

    @Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("EntrePaginas");
		primaryStage.show();
		telaInicial();
	}
    
}
