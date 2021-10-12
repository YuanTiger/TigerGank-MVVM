package com.my.gank.test

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.my.gank.R
import com.my.gank.base.lifecycle.ActivityLifecycleObserver
import com.my.gank.test.lifecycle.MyLocationService
import com.my.gank.utils.LogUtils

/**
 * Author: mengyuan
 * Date  : 2021/9/17/10:27 上午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
class TestActivity2 : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_test2)


        findViewById<TextView>(R.id.tv_start).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_finish).setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_start -> {
                val intent = Intent(this, MyLocationService::class.java)
                startService(intent)
            }
            R.id.tv_finish -> {
                val intent = Intent(this, MyLocationService::class.java)
                stopService(intent)
            }
        }

    }


}