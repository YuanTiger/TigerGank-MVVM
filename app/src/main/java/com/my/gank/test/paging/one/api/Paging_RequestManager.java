package com.my.gank.test.paging.one.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: mengyuan
 * Date  : 2021/10/25/2:30 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class Paging_RequestManager {

    private static final Paging_RequestManager ourInstance = new Paging_RequestManager();

    private Retrofit retrofit;


    public static Paging_RequestManager getInstance() {
        return ourInstance;
    }

    private Paging_RequestManager() {

        retrofit = new Retrofit.Builder()
                .baseUrl("http://yt-voice-api.yindui.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build();

    }

    private OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    public Paging_Api getApi(){
        return retrofit.create(Paging_Api.class);
    }
}
