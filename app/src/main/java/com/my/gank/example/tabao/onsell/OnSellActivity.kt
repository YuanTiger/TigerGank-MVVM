package com.my.gank.example.tabao.onsell

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

/**
 * Author: mengyuan
 * Date  : 2021/11/1/5:47 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
class OnSellActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this).get(OnSellViewModel::class.java)

        viewModel.loadContent()
    }
}