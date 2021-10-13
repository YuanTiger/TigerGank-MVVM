package com.my.gank.test.viewmodel;

import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.my.gank.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/6:50 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class ViewModelTestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView testView;

    private ViewModelTest viewModelTest;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_model);

        testView = findViewById(R.id.tv_test);
        findViewById(R.id.tv_add).setOnClickListener(this);

        viewModelTest = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(ViewModelTest.class);

        viewModelTest.getTestNum().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                testView.setText(String.valueOf(integer));
            }
        });

        testView.setText(String.valueOf(viewModelTest.getTestNum()));

        startTimer();
    }

    private void startTimer() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                viewModelTest.getTestNum().postValue(viewModelTest.getTestNum().getValue() + 1);
            }
        }, 1000, 1000);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_add:
                testView.setText(String.valueOf(viewModelTest.getTestNum()));
                break;
        }
    }
}
