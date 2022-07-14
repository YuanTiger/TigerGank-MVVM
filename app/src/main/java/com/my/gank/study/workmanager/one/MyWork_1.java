package com.my.gank.study.workmanager.one;

import android.content.Context;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.work.Data;
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
        String input_data = getInputData().getString("input_data");
        SystemClock.sleep(1000 * 2);
        LogUtils.iTag("YuanTiger","WorkManager-doWork::"+input_data);

        //任务执行完成，返回数据

        Data data = new Data.Builder()
                .putString("output_data","执行成功")
                .build();

//        return Result.success();
        return Result.success(data);
    }
}
