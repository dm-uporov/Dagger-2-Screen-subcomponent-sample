package ru.htc_cs.duporov.dagger2sample.ui.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.htc_cs.duporov.dagger2sample.R;
import ru.htc_cs.duporov.dagger2sample.business.Model;
import ru.htc_cs.duporov.dagger2sample.ui.Listener;

public class ListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final Context context;
    private final Listener listener;

    @Bind(R.id.colored_line)
    View coloredLine;

    @Bind(R.id.state)
    TextView state;

    @Bind(R.id.city)
    TextView city;

    public ListItemViewHolder(View itemView, Listener listener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        context = itemView.getContext();
        this.listener = listener;
    }

    public void bind(Model model) {
        coloredLine.setBackgroundColor(ContextCompat.getColor(context, model.getColor()));
        state.setText(model.getState());
        city.setText(model.getCity());
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        if (position != RecyclerView.NO_POSITION) {
            listener.onViewHolderClick(position);
        }
    }
}
