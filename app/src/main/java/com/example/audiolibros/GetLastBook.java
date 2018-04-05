package com.example.audiolibros;

public class GetLastBook {
    private final BooksRepository booksRepository;

    public GetLastBook(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public int execute() {
        return booksRepository.getLastBook();
    }

}
