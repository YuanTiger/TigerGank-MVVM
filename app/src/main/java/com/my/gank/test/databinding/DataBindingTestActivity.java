package com.my.gank.test.databinding;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.my.gank.R;
import com.my.gank.databinding.ActivityDataBindingBinding;
import com.my.gank.test.viewmodel.one.ViewModelTest;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/6:50 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class DataBindingTestActivity extends AppCompatActivity {


    private ActivityDataBindingBinding viewDataBinding;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        Idol idol = new Idol("YuanTiger","*****");
        viewDataBinding.setIdol(idol);
        viewDataBinding.setEventHandler(new EventHandleListener(this));
    }


}
