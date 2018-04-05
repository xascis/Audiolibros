package com.example.audiolibros;

public interface LibroStorage {
    boolean hasLastBook();
    int getLastBook();
    void saveLastBook(int id);
}
