package com.example.audiolibros;

public class HasLastBook {
    private final LibroStorage libroStorage;

    public HasLastBook(LibroStorage libroStorage) {
        this.libroStorage = libroStorage;
    }

    public boolean execute() {
        return libroStorage.hasLastBook();
    }
}
