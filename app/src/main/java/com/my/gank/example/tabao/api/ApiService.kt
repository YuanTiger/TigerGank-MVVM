package com.my.gank.example.tabao.api

import android.security.identity.ResultData
import com.my.gank.example.tabao.onsell.bean.OnSellData
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Author: mengyuan
 * Date  : 2021/11/1/5:57 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
interface ApiService {

    companion object{
        const val  BASE_URL = "https://api.sunofbeach.net/shop/"
    }



    @GET("onSell/{page}")
    suspend fun getOnSellList(@Path("page") page:Int):ResultData_TaoBao<OnSellData>  
}