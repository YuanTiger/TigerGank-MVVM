package com.my.gank.test.databinding.four;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.my.gank.R;
import com.my.gank.databinding.ActivityDataBinding3Binding;
import com.my.gank.databinding.ActivityDataBinding4Binding;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/6:50 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class DataBindingTestActivity_4 extends AppCompatActivity {


    private ActivityDataBinding4Binding viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_4);

        DataBinding_UserViewModel userViewModel = new DataBinding_UserViewModel();

        viewDataBinding.setUserViewModel(userViewModel);

    }


}
