package com.my.gank.study.lifecycle;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import org.jetbrains.annotations.NotNull;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/4:05 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class MyChronometer extends Chronometer implements DefaultLifecycleObserver {

    private long elapseTime;

    public MyChronometer(Context context) {
        super(context);
    }

    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyChronometer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyChronometer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public void onResume(@NonNull @NotNull LifecycleOwner owner) {

        setBase(SystemClock.elapsedRealtime() - elapseTime);

        start();

    }


    @Override
    public void onPause(@NonNull @NotNull LifecycleOwner owner) {
        elapseTime = SystemClock.elapsedRealtime() - getBase();
        stop();
    }


}
