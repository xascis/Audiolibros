package com.example.audiolibros;

public class MainController {
    LibroStorage libroStorage;

    public MainController(LibroStorage libroStorage) {
        this.libroStorage = libroStorage;
    }

    public void saveLastBook(int id) {
        libroStorage.saveLastBook(id);
    }
}
