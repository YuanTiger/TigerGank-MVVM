package com.my.gank.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.my.gank.R
import com.my.gank.base.lifecycle.ActivityLifecycleObserver
import com.my.gank.test.databinding.five.DataBindingTestActivity_5
import com.my.gank.test.databinding.four.DataBindingTestActivity_4
import com.my.gank.test.databinding.one.DataBindingTestActivity
import com.my.gank.test.databinding.seven.DataBindingTestActivity_7
import com.my.gank.test.databinding.six.DataBindingTestActivity_6
import com.my.gank.test.databinding.three.DataBindingTestActivity_3
import com.my.gank.test.databinding.two.DataBindingTestActivity_2
import com.my.gank.test.lifecycle.MyChronometer
import com.my.gank.test.navigation.one.Navigation_Activity_1
import com.my.gank.test.navigation.two.Navigation_Activity_2
import com.my.gank.test.room.one.RoomTestActivity_1
import com.my.gank.test.room.two.RoomTestActivity_2

/**
 * Author: mengyuan
 * Date  : 2021/9/16/6:54 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    val TAG = "MainActivity_";

    var chronometer2: MyChronometer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(object : ActivityLifecycleObserver() {})
        findViewById<TextView>(R.id.tv_test).setOnClickListener(this)

        chronometer2 = findViewById(R.id.chronometer)
        lifecycle.addObserver(chronometer2 ?: return)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_test -> {
                val intent = Intent(this, Navigation_Activity_2::class.java)
                startActivity(intent)
            }
            else -> {

            }
        }
    }

}