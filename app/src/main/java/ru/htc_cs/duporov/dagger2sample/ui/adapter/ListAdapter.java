package ru.htc_cs.duporov.dagger2sample.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import ru.htc_cs.duporov.dagger2sample.business.Model;

public class ListAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    private final ListItemViewHolderFactory factory;
    private final List<Model> models;

    public ListAdapter(ListItemViewHolderFactory factory, List<Model> models) {
        this.factory = factory;
        this.models = models;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return factory.createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.bind(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
