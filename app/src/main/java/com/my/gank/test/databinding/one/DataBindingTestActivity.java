package com.my.gank.test.databinding.one;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.my.gank.R;
import com.my.gank.databinding.ActivityDataBindingBinding;

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
