package com.example.audiolibros;

public class HasLastBook {
    private final BooksRepository booksRepository;

    public HasLastBook(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public boolean execute() {
        return booksRepository.hasLastBook();
    }
}
