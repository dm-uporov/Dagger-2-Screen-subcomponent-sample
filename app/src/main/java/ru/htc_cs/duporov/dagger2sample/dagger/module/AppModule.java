package ru.htc_cs.duporov.dagger2sample.dagger.module;

import android.content.Context;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.htc_cs.duporov.dagger2sample.App;
import ru.htc_cs.duporov.dagger2sample.ui.ListFragment;

@Module
public class AppModule {

    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return app;
    }

    @Singleton
    @Provides
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(app);
    }

    @Provides
    ListFragment provideListFragment() {
        return ListFragment.newInstance();
    }
}
