package com.my.gank.study.workmanager.one;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;

import com.my.gank.R;

import java.util.ArrayList;
import java.util.List;

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

        OneTimeWorkRequest work2 = new OneTimeWorkRequest.Builder(MyWork_2.class).build();
        OneTimeWorkRequest work3 = new OneTimeWorkRequest.Builder(MyWork_3.class).build();
        OneTimeWorkRequest work4 = new OneTimeWorkRequest.Builder(MyWork_4.class).build();
        OneTimeWorkRequest work5 = new OneTimeWorkRequest.Builder(MyWork_5.class).build();
        OneTimeWorkRequest work6 = new OneTimeWorkRequest.Builder(MyWork_6.class).build();


        WorkContinuation then = WorkManager.getInstance(this).beginWith(work2).then(work3);
        WorkContinuation then2 = WorkManager.getInstance(this).beginWith(work4).then(work5);


        List<WorkContinuation> workContinuationList = new ArrayList<>();
        workContinuationList.add(then);
        workContinuationList.add(then2);

        //2、3、4、5任务顺序随机，但是6任务一定是在最后
        WorkContinuation.combine(workContinuationList)
                .then(work6)
                .enqueue();

//        //触发条件
//        Constraints constraints = new Constraints.Builder()
//                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
//                .build();
//
//
//        Data inputData = new Data.Builder()
//                .putString("input_data","YuanString")
//                .build();
//
//        OneTimeWorkRequest workRequest1 = new OneTimeWorkRequest.Builder(MyWork_1.class)
//                //设置触发条件
//                .setConstraints(constraints)
//                //设置延迟执行
//                .setInitialDelay(5, TimeUnit.SECONDS)
//                //指数退避策略
//                .setBackoffCriteria(BackoffPolicy.LINEAR, 2, TimeUnit.SECONDS)
//                //设置tag标签
//                .addTag("workTest")
//                .setInputData(inputData)
//                .build();
//
//        //周期性任务
//        //不能少于15分钟
//        PeriodicWorkRequest build = new PeriodicWorkRequest.Builder(MyWork_1.class, 15,TimeUnit.MINUTES)
//                .build();
//
//        WorkManager workManager = WorkManager.getInstance(this);
//        workManager.enqueue(workRequest1);
//        workManager.getWorkInfoByIdLiveData(workRequest1.getId()).observe(this, new Observer<WorkInfo>() {
//            @Override
//            public void onChanged(WorkInfo workInfo) {
//                LogUtils.iTag("YuanTiger","WorkManager-onChanged");
//                if(workInfo != null && workInfo.getState() == WorkInfo.State.SUCCEEDED){
//                    String output_data = workInfo.getOutputData().getString("output_data");
//                    LogUtils.iTag("YuanTiger","WorkManager-onChanged:"+output_data);
//                }
//            }
//        });

//        //取消任务
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                workManager.cancelWorkById(workRequest1.getId());
//            }
//        },2000);

    }
}
