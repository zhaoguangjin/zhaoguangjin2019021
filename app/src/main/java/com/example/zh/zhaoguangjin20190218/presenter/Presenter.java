package com.example.zh.zhaoguangjin20190218.presenter;

import com.example.zh.zhaoguangjin20190218.MainActivity;
import com.example.zh.zhaoguangjin20190218.model.Model;

public class Presenter implements Presenterintenter, Model.getdata {
    MainActivity activity;
    private final Model model;

    public Presenter(MainActivity activity1) {
        this.activity = activity1;
        model = new Model(this);
    }

    @Override
    public void getpresenter() {
        model.getmodel();
    }

    @Override
    public void getmodels(String s) {
        activity.getview(s);
    }
}
