package com.example.audiolibros;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private static VolleySingleton instance;
    private RequestQueue colaPeticiones;
    private ImageLoader lectorImagenes;
    private Context context;

    private VolleySingleton(Context context) {
        this.context = context;
    }

    public static VolleySingleton getInstance(Context context) {
        if (instance == null) {
            instance = new VolleySingleton(context);
            instance.inicializa();
        }
        return instance;
    }

    private void inicializa() {
        colaPeticiones = Volley.newRequestQueue(context);
        lectorImagenes = new ImageLoader(colaPeticiones,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap> cache =
                            new LruCache<String, Bitmap>(10);

                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }

                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }
                });
    }

    public RequestQueue getColaPeticiones() {
        return colaPeticiones;
    }

    public void setColaPeticiones(RequestQueue colaPeticiones) {
        this.colaPeticiones = colaPeticiones;
    }

    public ImageLoader getLectorImagenes() {
        return lectorImagenes;
    }

    public void setLectorImagenes(ImageLoader lectorImagenes) {
        this.lectorImagenes = lectorImagenes;
    }
}
