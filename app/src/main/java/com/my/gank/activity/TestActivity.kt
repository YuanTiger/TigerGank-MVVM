package com.my.gank.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.my.gank.R
import com.my.gank.base.lifecycle.ActivityLifecycleObserver
import com.my.gank.utils.LogUtils

/**
 * Author: mengyuan
 * Date  : 2021/9/17/10:27 上午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
class TestActivity : AppCompatActivity() {

    val TAG = "TestActivity_"

    lateinit var liveData: MutableLiveData<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_test)

        lifecycle.addObserver(object : ActivityLifecycleObserver() {})

        liveData = MutableLiveData()
        liveData.observe(this, object : Observer<String> {

            override fun onChanged(t: String?) {
                LogUtils.iTag(TAG, "onChange:$t")
            }
        })
    }


    override fun onStart() {
        super.onStart()
        LogUtils.iTag(TAG, "onStart()")
        liveData.value = "onStart"
    }

    override fun onStop() {
        super.onStop()
        LogUtils.iTag(TAG, "onStop()")
        liveData.value = "onStop"

    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.iTag(TAG, "onDestroy()")
        liveData.value = "onDestroy"

    }


    override fun onResume() {
        super.onResume()
        LogUtils.iTag(TAG, "onResume()")
        liveData.value = "onResume"
    }

    override fun onPause() {
        super.onPause()
        LogUtils.iTag(TAG, "onPause()")
        liveData.value = "onPause"
    }
}