package com.my.gank.base.lifecycle

import androidx.lifecycle.*
import com.my.gank.utils.LogUtils

/**
 * Author: mengyuan
 * Date  : 2021/9/16/7:15 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
open class ActivityLifecycleObserver : DefaultLifecycleObserver {

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

        LogUtils.iTag(TAG, "connect-onStart()-owner:" + owner.lifecycle.toString())
    }

    /**
     * Notifies that `ON_PAUSE` event occurred.
     *
     *
     * This method will be called before the [LifecycleOwner]'s `onPause` method
     * is called.
     *
     * @param owner the component, whose state was changed
     */
    override fun onPause(owner: LifecycleOwner) {
        LogUtils.iTag(TAG, "disconnect-onPause()")

    }

    /**
     * Notifies that `ON_RESUME` event occurred.
     *
     *
     * This method will be called after the [LifecycleOwner]'s `onResume`
     * method returns.
     *
     * @param owner the component, whose state was changed
     */
    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
    }


}