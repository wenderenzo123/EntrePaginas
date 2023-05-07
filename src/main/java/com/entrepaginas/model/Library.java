package com.entrepaginas.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import com.entrepaginas.utils.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private Map<String, Book> bookMap;
    private Queue<Book> waitingList;
    private Stack<Book> recentBooks;

    public Library() {
        this.books = new ArrayList<>();
        this.bookMap = new HashMap<>();
        this.waitingList = new LinkedList<>();
        this.recentBooks = new Stack<>();
    }

    public void addBook(Book book) {
        books.add(book);
        bookMap.put(book.getIsbn(), book);
        recentBooks.push(book);
    }

    public Book findBook(String isbn) {
        return bookMap.get(isbn);
    }

    public void borrowBook(String isbn) {
        Book book = bookMap.get(isbn);
        if (book.isAvailable()) {
            book.setAvailable(false);
        } else {
            waitingList.add(book);
        }
    }

    public void returnBook(String isbn) {
        Book book = bookMap.get(isbn);
        book.setAvailable(true);
        recentBooks.push(book);
    }

    public ArrayList<Book> returnBooks() {
        return books;
    }

    public Book getRecentBook() {
        if (recentBooks.empty()) {
            return null;
        }
        return recentBooks.peek();
    }

    public void printBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void removeBook(String isbn) {
        Book book = bookMap.get(isbn);
        books.remove(book);
        bookMap.remove(isbn);
    }

    public void updateBook(String isbn, String newBook) {
        Book book = bookMap.get(isbn);
        book.setTitle(newBook);
    }

    public void printAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void printWaitingList() {
        for (Book book : waitingList) {
            System.out.println(book);
        }
    }

    public void printUnvailableBooks() {
        for (Book book : books) {
            if (!book.isAvailable()) {
                System.out.println(book);
            }
        }
    }
}
