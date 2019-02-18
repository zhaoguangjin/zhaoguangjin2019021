package com.example.zh.zhaoguangjin20190218.model;

import com.example.zh.zhaoguangjin20190218.add.Okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Model implements Modelintenter {
    private String path = "http://365jia.cn/news/api3/365jia/news/headline?page=1";
    getdata getdata;

    public Model(getdata getdata1) {
        this.getdata = getdata1;
    }

    @Override
    public void getmodel() {

        Okhttp.get(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                getdata.getmodels(string);

            }
        });
    }

    public interface getdata {
        void getmodels(String s);
    }

}
