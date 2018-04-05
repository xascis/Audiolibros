package com.example.audiolibros;

import android.content.Context;
import android.content.SharedPreferences;

public class LibroSharedPreferenceStorage implements LibroStorage{
    public static final String PREF_AUDIOLIBROS = "com.example.audiolibros_internal";
    public static final String KEY_ULTIMO_LIBRO = "ultimo";
    private final Context context;
    private static LibroSharedPreferenceStorage instance;

    private LibroSharedPreferenceStorage(Context context) {
        this.context = context;
    }

    public static LibroStorage getInstance(Context context) {
        if (instance == null) {
            instance = new LibroSharedPreferenceStorage(context);
        }
        return instance;
    }

    @Override
    public boolean hasLastBook() {
        return getPreference().contains(KEY_ULTIMO_LIBRO);
    }

    private SharedPreferences getPreference() {
        return context.getSharedPreferences(PREF_AUDIOLIBROS, Context.MODE_PRIVATE);
    }

    @Override
    public int getLastBook() {
        return getPreference().getInt(KEY_ULTIMO_LIBRO, -1);
    }


    @Override
    public void saveLastBook(int id) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_AUDIOLIBROS, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ULTIMO_LIBRO, id);
        editor.commit();
    }
}

