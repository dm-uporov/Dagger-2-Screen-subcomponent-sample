package ru.htc_cs.duporov.dagger2sample.dagger.component;


import dagger.Subcomponent;
import ru.htc_cs.duporov.dagger2sample.dagger.module.ListModule;
import ru.htc_cs.duporov.dagger2sample.dagger.scope.ListScope;
import ru.htc_cs.duporov.dagger2sample.ui.ListFragment;

@ListScope
@Subcomponent(modules = ListModule.class)
public interface ListComponent {

    void inject(ListFragment listFragment);
}
