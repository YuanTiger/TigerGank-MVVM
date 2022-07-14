package com.my.gank.study.databinding.three;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.my.gank.R;
import com.my.gank.databinding.ActivityDataBinding3Binding;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/6:50 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class DataBindingTestActivity_3 extends AppCompatActivity {


    private ActivityDataBinding3Binding viewDataBinding;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_3);

//        viewDataBinding.setNetworkImage("http://pic-api.yindui.net/group1/M00/0B/DA/wKgACmFhoqGEJoQGAAAAAD1ZT4I307.png?x-oss-process=image/resize,m_fixed,w_240,h_240/quality,q_50");

        viewDataBinding.setLocalImage(R.mipmap.ic_data_binding);


    }


}
