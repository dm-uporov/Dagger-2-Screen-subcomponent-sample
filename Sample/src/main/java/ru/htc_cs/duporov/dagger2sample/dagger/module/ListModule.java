package ru.htc_cs.duporov.dagger2sample.dagger.module;

import android.view.LayoutInflater;

import java.util.Arrays;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import ru.htc_cs.duporov.dagger2sample.business.Model;
import ru.htc_cs.duporov.dagger2sample.dagger.scope.ListScope;
import ru.htc_cs.duporov.dagger2sample.ui.ListFragment;
import ru.htc_cs.duporov.dagger2sample.ui.adapter.ListAdapter;
import ru.htc_cs.duporov.dagger2sample.ui.adapter.ListItemViewHolderFactory;

@Module
public class ListModule {

    private final ListFragment listFragment;

    public ListModule(ListFragment listFragment) {
        this.listFragment = listFragment;
    }

    @ListScope
    @Provides
    ListAdapter provideListAdapter(ListItemViewHolderFactory factory, List<Model> list) {
        return new ListAdapter(factory, list);
    }

    @ListScope
    @Provides
    ListItemViewHolderFactory provideListItemViewHolderFactory(LayoutInflater layoutInflater) {
        return new ListItemViewHolderFactory(layoutInflater, listFragment);
    }

    @ListScope
    @Provides
    List<Model> provideModels() {
         return Arrays.asList(
                new Model("Russia", "Izhevsk", android.R.color.holo_red_dark),
                new Model("Russia", "Moscow", android.R.color.holo_purple),
                new Model("USA", "Washington", android.R.color.holo_orange_dark),
                new Model("Ukraine", "Kiev", android.R.color.holo_blue_dark),
                new Model("Serbia", "Belgrade", android.R.color.holo_green_dark)
        );
    }
}
