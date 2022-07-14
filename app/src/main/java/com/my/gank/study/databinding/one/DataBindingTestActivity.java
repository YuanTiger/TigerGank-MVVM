package com.my.gank.study.databinding.one;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.my.gank.R;
import com.my.gank.databinding.ActivityDataBinding1Binding;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/6:50 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class DataBindingTestActivity extends AppCompatActivity {


    private ActivityDataBinding1Binding viewDataBinding;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_1);

        Idol idol = new Idol("YuanTiger","*****");
        viewDataBinding.setIdol(idol);
        viewDataBinding.setEventHandler(new EventHandleListener(this));
    }


}
