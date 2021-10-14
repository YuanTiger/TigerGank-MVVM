package com.my.gank.test.databinding.five;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.my.gank.R;
import com.my.gank.databinding.ActivityDataBinding4Binding;
import com.my.gank.databinding.ActivityDataBinding5Binding;
import com.my.gank.test.databinding.four.DataBinding_UserViewModel;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/6:50 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class DataBindingTestActivity_5 extends AppCompatActivity {


    private ActivityDataBinding5Binding viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_5);

        DataBinding_UserViewModel_5 userViewModel = new DataBinding_UserViewModel_5();

        viewDataBinding.setUserViewModel(userViewModel);

    }


}
