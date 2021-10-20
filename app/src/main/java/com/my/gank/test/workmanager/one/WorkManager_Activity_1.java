package com.my.gank.test.workmanager.one;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.my.gank.R;

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



    public void startTask(View view){
        //触发条件
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .build();


        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWork_1.class)

                .setConstraints(constraints)
                .build();

        WorkManager workManager = WorkManager.getInstance(this);
        workManager.enqueue(workRequest);

    }
}
