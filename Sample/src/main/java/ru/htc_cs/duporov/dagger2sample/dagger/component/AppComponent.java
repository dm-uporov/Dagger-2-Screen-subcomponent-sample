package ru.htc_cs.duporov.dagger2sample.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.htc_cs.duporov.dagger2sample.dagger.module.AppModule;
import ru.htc_cs.duporov.dagger2sample.dagger.module.ListModule;
import ru.htc_cs.duporov.dagger2sample.ui.MainActivity;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    ListComponent listComponent(ListModule listModule);

    void inject(MainActivity mainActivity);
}
