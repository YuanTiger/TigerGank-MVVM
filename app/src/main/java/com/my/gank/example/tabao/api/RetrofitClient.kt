package com.my.gank.example.tabao.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Author: mengyuan
 * Date  : 2021/11/1/5:55 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 * 提供API Service
 */
object RetrofitClient {

    val okHttpClient = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(ApiService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    val apiService = retrofit.create(ApiService::class.java)

}
