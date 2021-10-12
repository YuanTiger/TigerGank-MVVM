package com.my.gank.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.my.gank.R
import com.my.gank.base.lifecycle.ActivityLifecycleObserver
import com.my.gank.utils.LogUtils

/**
 * Author: mengyuan
 * Date  : 2021/9/16/6:54 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    val TAG = "MainActivity_";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lifecycle.addObserver(object : ActivityLifecycleObserver() {})

        findViewById<TextView>(R.id.tv_test).setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_test -> {
                val intent = Intent(this, TestActivity::class.java)
                startActivity(intent)
            }
            else -> {

            }
        }
    }

}