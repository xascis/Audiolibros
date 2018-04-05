package com.example.audiolibros;

public class GetLastBook {
    private final LibroStorage libroStorage;

    public GetLastBook(LibroStorage libroStorage) {
        this.libroStorage = libroStorage;
    }

    public int execute() {
        return libroStorage.getLastBook();
    }

}
