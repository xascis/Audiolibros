package com.example.audiolibros;


import android.support.v7.widget.SearchView;

import java.util.Observable;

public class SearchObservable extends Observable implements SearchView.OnQueryTextListener {
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        setChanged();
        notifyObservers(newText);
        return false;
    }
}
