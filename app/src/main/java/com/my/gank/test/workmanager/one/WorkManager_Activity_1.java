package com.my.gank.test.workmanager.one;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.my.gank.R;
import com.my.gank.utils.LogUtils;

import java.time.Duration;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Author: mengyuan
 * Date  : 2021/10/20/11:42 上午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class WorkManager_Activity_1 extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager_1);
    }


    public void startTask(View view) {
        //触发条件
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .build();


        Data inputData = new Data.Builder()
                .putString("input_data","YuanString")
                .build();
        OneTimeWorkRequest workRequest1 = new OneTimeWorkRequest.Builder(MyWork_1.class)
                //设置触发条件
                .setConstraints(constraints)
                //设置延迟执行
                .setInitialDelay(5, TimeUnit.SECONDS)
                //指数退避策略
                .setBackoffCriteria(BackoffPolicy.LINEAR, 2, TimeUnit.SECONDS)
                //设置tag标签
                .addTag("workTest")
                .setInputData(inputData)
                .build();

        WorkManager workManager = WorkManager.getInstance(this);
        workManager.enqueue(workRequest1);
        workManager.getWorkInfoByIdLiveData(workRequest1.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                LogUtils.iTag("YuanTiger","WorkManager-onChanged");
                if(workInfo != null && workInfo.getState() == WorkInfo.State.SUCCEEDED){
                    String output_data = workInfo.getOutputData().getString("output_data");
                    LogUtils.iTag("YuanTiger","WorkManager-onChanged:"+output_data);
                }
            }
        });

//        //取消任务
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                workManager.cancelWorkById(workRequest1.getId());
//            }
//        },2000);

    }
}
