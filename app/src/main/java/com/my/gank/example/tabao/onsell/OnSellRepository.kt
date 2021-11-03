package com.my.gank.example.tabao.onsell

import com.my.gank.example.tabao.api.RetrofitClient

/**
 * Author: mengyuan
 * Date  : 2021/11/1/5:49 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
class OnSellRepository {

    suspend fun getOnSellList(page: Int) =
        RetrofitClient.apiService.getOnSellList(page).apiData()

}