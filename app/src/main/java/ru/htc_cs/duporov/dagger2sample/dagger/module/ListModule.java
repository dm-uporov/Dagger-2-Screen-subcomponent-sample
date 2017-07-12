package ru.htc_cs.duporov.dagger2sample.dagger.module;

import android.view.LayoutInflater;

import dagger.Module;
import dagger.Provides;
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
    ListAdapter provideListAdapter(ListItemViewHolderFactory factory) {
        return new ListAdapter(factory, listFragment.initList());
    }

    @ListScope
    @Provides
    ListItemViewHolderFactory provideListItemViewHolderFactory(LayoutInflater layoutInflater) {
        return new ListItemViewHolderFactory(layoutInflater, listFragment);
    }
}
