package com.my.gank.test.lifecycle;

import androidx.lifecycle.LifecycleService;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/4:25 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class MyLocationService extends LifecycleService {


    public MyLocationService() {
        super();
        MyLocationObserver observer = new MyLocationObserver(this);
        getLifecycle().addObserver(observer);

    }
}
