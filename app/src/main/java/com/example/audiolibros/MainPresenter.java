package com.example.audiolibros;

public class MainPresenter {
    private final SaveLastBook saveLastBook;
    private final HasLastBook hasLastBook;
    private final GetLastBook getLastBook;
//    private final LibroStorage libroStorage;
    private final View view;

    public MainPresenter(SaveLastBook saveLastBook,
                         HasLastBook hasLastBook,
                         GetLastBook getLastBook,
//                         LibroStorage libroStorage,
                         MainPresenter.View view) {
        this.saveLastBook = saveLastBook;
        this.hasLastBook = hasLastBook;
        this.getLastBook = getLastBook;
//        this.libroStorage = libroStorage;
        this.view = view;
    }

    public void clickFavoriteButton() {
        if (hasLastBook.execute()) {
            view.mostrarFragmentDetalle(getLastBook.execute());
        } else {
            view.mostrarNoUltimaVisita();
        }
    }

    public void openDetalle(int id) {
//        libroStorage.saveLastBook(id);
        saveLastBook.execute(id);
        view.mostrarFragmentDetalle(id);
    }

    public interface View {
        void mostrarFragmentDetalle(int lastBook);

        void mostrarNoUltimaVisita();
    }
}
