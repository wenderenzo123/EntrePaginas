package com.entrepaginas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.entrepaginas.model.Book;
import com.entrepaginas.model.Client;

public class File {
    public static String Read(String Caminho) {
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    conteudo += linha;
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

    public static <T> boolean Write(String Caminho, ArrayList<T> arrayList, int type) {
        try {
            FileWriter arq = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq);

            switch (type) {
                case 1:
                    for (T book : arrayList) {
                        gravarArq.println(((Book) book).getTitle() + "," + ((Book) book).getAuthor() + ","
                                + ((Book) book).getIsbn() + "," + ((Book) book).getQtd() + ";");
                    }
                    break;
                case 2:
                    for (T client : arrayList) {
                        gravarArq.println(((Client) client).getid() + "," + ((Client) client).getUsername() + ","
                                + ((Client) client).getEmail() + "," + ((Client) client).getPhone() + "," + ((Client) client).getBook() + ";");
                    }
                    break;
                default:
                    break;
            }
            gravarArq.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}