package com.my.gank.test.databinding.seven;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.my.gank.R;
import com.my.gank.databinding.ActivityDataBinding2Binding;
import com.my.gank.databinding.ActivityDataBinding7Binding;
import com.my.gank.test.databinding.one.EventHandleListener;
import com.my.gank.test.databinding.one.Idol;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/6:50 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class DataBindingTestActivity_7 extends AppCompatActivity {


    private ActivityDataBinding7Binding viewDataBinding;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_7);

        DataBinding_ViewModel_7 dataBinding_viewModel_7 = new DataBinding_ViewModel_7();

        viewDataBinding.setViewModel(dataBinding_viewModel_7);
        viewDataBinding.setLifecycleOwner(this);

    }


}
