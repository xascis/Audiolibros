package com.example.audiolibros;

public class SaveLastBook {
    private final LibroStorage libroStorage;

    public SaveLastBook(LibroStorage libroStorage) {
        this.libroStorage = libroStorage;
    }

    public void execute(int id) {
        libroStorage.saveLastBook(id);
    }
}
