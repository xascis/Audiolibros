package com.example.audiolibros;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.View;

public class OpenMenuLongClickAction implements LongClickAction {
    private MainActivity actividad;
    private AdaptadorLibrosFiltro adaptador;
    private View v;
    LibrosSingleton librosSingleton;

    public OpenMenuLongClickAction(MainActivity actividad, AdaptadorLibros adaptador, View v) {
        this.actividad = actividad;
        librosSingleton = LibrosSingleton.getInstance(actividad);
        this.adaptador = (AdaptadorLibrosFiltro) librosSingleton.getAdaptador();
        this.v = v;
    }

    @Override
    public void execute(final int position) {
        AlertDialog.Builder menu = new AlertDialog.Builder(actividad);
        CharSequence[] opciones = {"Compartir", "Borrar ", "Insertar"};
        menu.setItems(opciones, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int opcion) {
                switch (opcion) {
                    case 0: //Compartir
                        Libro libro = adaptador.getItem(position); //Faltaba esta línea
//                        Intent i = new Intent(Intent.ACTION_SEND);
//                        i.setType("text/plain");
//                        i.putExtra(Intent.EXTRA_SUBJECT, libro.titulo);
//                        i.putExtra(Intent.EXTRA_TEXT, libro.urlAudio);
//                        startActivity(Intent.createChooser(i, "Compartir"));
                        ((MainActivity) actividad).compartirLibro(libro);
                        break;
                    case 1: //Borrar
                        Snackbar.make(v, "¿Estás seguro?", Snackbar.LENGTH_LONG)
                                .setAction("SI", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        adaptador.borrar(position);
                                        adaptador.notifyDataSetChanged();
                                    }
                                })
                                .show();
                        break;  //Faltaba esta línea
                    case 2: //Insertar
//                        int posicion = recyclerView.getChildLayoutPosition(v);
                        adaptador.insertar(adaptador.getItem(position));
                        adaptador.notifyDataSetChanged();
                        Snackbar.make(v, "Libro insertado", Snackbar.LENGTH_INDEFINITE)
                                .setAction("OK", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                    }
                                })
                                .show();
                        break;
                }
            }
        });
        menu.create().show();
    }
}
