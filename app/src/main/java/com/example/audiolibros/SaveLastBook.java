package com.example.audiolibros;

public class SaveLastBook {
    private final BooksRepository booksRepository;

    public SaveLastBook(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public void execute(int id) {
        booksRepository.saveLastBook(id);
    }
}
