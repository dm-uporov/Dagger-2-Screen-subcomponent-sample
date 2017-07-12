package ru.htc_cs.duporov.dagger2sample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import ru.htc_cs.duporov.dagger2sample.App;

public class MainActivity extends AppCompatActivity {

    @Inject
    ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().getAppComponent().inject(this);
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, listFragment)
                .commit();
    }
}
