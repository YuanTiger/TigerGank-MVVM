package com.my.gank.base.lifecycle

import androidx.lifecycle.*
import com.my.gank.utils.LogUtils

/**
 * Author: mengyuan
 * Date  : 2021/9/16/7:15 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
open class AppLifecycleObserver : DefaultLifecycleObserver {

    val TAG = "MyLifecycleObserver_";

    /**
     * Notifies that `ON_START` event occurred.
     *
     *
     * This method will be called after the [LifecycleOwner]'s `onStart` method returns.
     *
     * @param owner the component, whose state was changed
     */
    override fun onStart(owner: LifecycleOwner) {

        LogUtils.iTag(TAG, "应用处于前台状态")
    }


    /**
     * Notifies that `ON_STOP` event occurred.
     *
     *
     * This method will be called before the [LifecycleOwner]'s `onStop` method
     * is called.
     *
     * @param owner the component, whose state was changed
     */
    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        LogUtils.iTag(TAG, "应用处于后台状态")

    }


}