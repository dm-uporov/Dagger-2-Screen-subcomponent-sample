package ru.htc_cs.duporov.dagger2sample.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.htc_cs.duporov.dagger2sample.R;
import ru.htc_cs.duporov.dagger2sample.ui.Listener;

public class ListItemViewHolderFactory {

    private final Listener listener;
    private final LayoutInflater layoutInflater;

    public ListItemViewHolderFactory(LayoutInflater layoutInflater, Listener listener) {
        this.layoutInflater = layoutInflater;
        this.listener = listener;
    }

    public ListItemViewHolder createViewHolder(ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_model, parent, false);
        return new ListItemViewHolder(view, listener);
    }
}
