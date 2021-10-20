package com.my.gank.test.workmanager.one;

import android.content.Context;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.my.gank.utils.LogUtils;

/**
 * Author: mengyuan
 * Date  : 2021/10/20/11:49 上午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class MyWork_1 extends Worker {


    public MyWork_1(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        SystemClock.sleep(1000 * 2);
        LogUtils.iTag("YuanTiger","doWork");
        return Result.success();
    }
}
