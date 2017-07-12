package ru.htc_cs.duporov.dagger2sample.business;

import android.support.annotation.ColorRes;

public class Model {

    private String state;
    private String city;
    @ColorRes
    private int color;

    public Model(String state, String city, @ColorRes int color) {
        this.state = state;
        this.city = city;
        this.color = color;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    @ColorRes
    public int getColor() {
        return color;
    }
}
