package com.example.zh.zhaoguangjin20190218;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.zh.zhaoguangjin20190218.adapter.Adapter;
import com.example.zh.zhaoguangjin20190218.add.Okhttp;
import com.example.zh.zhaoguangjin20190218.bean.Bean;
import com.example.zh.zhaoguangjin20190218.presenter.Presenter;
import com.example.zh.zhaoguangjin20190218.view.Viewintenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Viewintenter {
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1) {
                 String t=msg.obj.toString();
                Gson gson = new Gson();
                Bean bean = gson.fromJson(t, Bean.class);
                List<Bean.DataBeanX.DataBean> beans;
                beans = bean.getData().getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                final Adapter adapter = new Adapter(MainActivity.this, beans);
                recyclerView.setAdapter(adapter);
            }
        }
    };
    private RecyclerView recyclerView;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.RecyclerView);
        presenter = new Presenter(this);
        presenter.getpresenter();
    }

    @Override
    public void getview(final String data) {
        Log.i("AA", "ss" + data);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Message message = new Message();
                message.what=1;
                message.obj=data;
                handler.sendMessage(message);
            }
        });

;




    }


}
