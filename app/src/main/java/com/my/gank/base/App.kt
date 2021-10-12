package com.my.gank.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.ProcessLifecycleOwner
import com.my.gank.base.lifecycle.AppLifecycleObserver

/**
 * Author: mengyuan
 * Date  : 2021/9/16/7:18 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
class App : Application() {

    companion object {
        lateinit var context: Context
    }


    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        ProcessLifecycleOwner.get().lifecycle.addObserver(object :AppLifecycleObserver(){})

    }
}