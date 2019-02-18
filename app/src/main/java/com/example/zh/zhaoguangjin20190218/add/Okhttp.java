package com.example.zh.zhaoguangjin20190218.add;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Okhttp {
/*
    //拦截器
    private Interceptor getapp(){
      Interceptor interceptor = new Interceptor() {
          @Override
          public Response intercept(Chain chain) throws IOException {
              Request request = chain.request();
              Response proceed = chain.proceed(request);
              return proceed;
          }
      };
      return interceptor;
    };
    //单例*/
/* private static  Okhttp dan(Okhttp okhttp){
     if (okhttp == null) {
         Okhttp okhttp1 = new Okhttp();
         return okhttp1;
     } else {
         return okhttp;
     }

 }*/;

    public static void get(String url, Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().method("GET",null).url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
    public static void post(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody formBody = new FormBody.Builder().add("pag", "1").build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }


}
