package com.example.audiolibros;

public class BooksRepository {
    private final LibroStorage libroStorage;

    public BooksRepository(LibroStorage libroStorage) {
        this.libroStorage = libroStorage;
    }

    public int getLastBook() {
        return libroStorage.getLastBook();
    }

    public void saveLastBook(int id) {
        libroStorage.saveLastBook(id);
    }

    public boolean hasLastBook() {
        return libroStorage.hasLastBook();
    }
}
