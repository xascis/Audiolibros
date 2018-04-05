package com.example.audiolibros;

public class MainPresenter {
    private final LibroStorage libroStorage;
    private final View view;

    public MainPresenter(LibroStorage libroStorage, MainPresenter.View view) {
        this.libroStorage = libroStorage;
        this.view = view;
    }

    public void clickFavoriteButton() {
        if (libroStorage.hasLastBook()) {
            view.mostrarDetalle(libroStorage.getLastBook());
        } else {
            view.mostrarNoUltimaVisita();
        }
    }

    public void openDetalle(int id) {
        libroStorage.saveLastBook(id);
        view.mostrarDetalle(id);
    }

    public interface View {
        void mostrarDetalle(int lastBook);
        void mostrarNoUltimaVisita();
    }
}
