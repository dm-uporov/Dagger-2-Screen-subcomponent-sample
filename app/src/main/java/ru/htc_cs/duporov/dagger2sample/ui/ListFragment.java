package ru.htc_cs.duporov.dagger2sample.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.htc_cs.duporov.dagger2sample.App;
import ru.htc_cs.duporov.dagger2sample.R;
import ru.htc_cs.duporov.dagger2sample.business.Model;
import ru.htc_cs.duporov.dagger2sample.ui.adapter.ListAdapter;

public class ListFragment extends Fragment implements Listener {

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Inject
    ListAdapter listAdapter;

    @Bind(R.id.recycler)
    RecyclerView recyclerView;

    private List<Model> modelList = Arrays.asList(
            new Model("Russia", "Izhevsk", android.R.color.holo_red_dark),
            new Model("Russia", "Moscow", android.R.color.holo_purple),
            new Model("USA", "Washington", android.R.color.holo_orange_dark),
            new Model("Ukraine", "Kiev", android.R.color.holo_blue_dark),
            new Model("Serbia", "Belgrade", android.R.color.holo_green_dark)
    );

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().initListComponent(this).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
    }

    public List<Model> initList() {
        return modelList;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        App.getInstance().destroyListComponent();
    }

    @Override
    public void onViewHolderClick(int position) {
        Model model = modelList.get(position);
        Toast.makeText(getContext(),
                model.getState()
                        .concat(", ")
                        .concat(model.getCity()),
                Toast.LENGTH_SHORT)
                .show();
    }
}
