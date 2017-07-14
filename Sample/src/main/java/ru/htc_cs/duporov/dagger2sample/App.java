package ru.htc_cs.duporov.dagger2sample;

import android.app.Application;

import ru.htc_cs.duporov.dagger2sample.dagger.component.AppComponent;
import ru.htc_cs.duporov.dagger2sample.dagger.component.DaggerAppComponent;
import ru.htc_cs.duporov.dagger2sample.dagger.component.ListComponent;
import ru.htc_cs.duporov.dagger2sample.dagger.module.AppModule;
import ru.htc_cs.duporov.dagger2sample.dagger.module.ListModule;
import ru.htc_cs.duporov.dagger2sample.ui.ListFragment;

public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    private AppComponent appComponent;
    private ListComponent listComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDagger();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public ListComponent initListComponent(ListFragment listFragment) {
        listComponent = appComponent.listComponent(new ListModule(listFragment));
        return listComponent;
    }

    public ListComponent getListComponent() {
        return listComponent;
    }

    public void destroyListComponent() {
        listComponent = null;
    }
}
