package com.example.audiolibros;

import android.content.Context;

import java.util.List;

public class LibrosSingleton {
    private static LibrosSingleton instance;
    private Context context;

    private List<Libro> vectorLibros;
    private AdaptadorLibros adaptadorLibros;

    private LibrosSingleton(Context context) {
        this.context = context;
    }

    public AdaptadorLibros getAdaptador() {
        return adaptadorLibros;
    }

    public List<Libro> getVectorLibros() {
        return vectorLibros;
    }

    public static LibrosSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new LibrosSingleton(context);
            instance.inicializa();
        }
        return instance;
    }

    private void inicializa() {
        vectorLibros = Libro.ejemploLibros();
        adaptadorLibros = new AdaptadorLibrosFiltro(context);
    }

    public void setAdaptador(AdaptadorLibros adaptadorLibros) {
        this.adaptadorLibros = adaptadorLibros;
    }

    public void setVectorLibros(List<Libro> vectorLibros) {
        this.vectorLibros = vectorLibros;
    }
}
