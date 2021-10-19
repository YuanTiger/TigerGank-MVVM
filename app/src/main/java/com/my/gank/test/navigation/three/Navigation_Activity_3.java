package com.my.gank.test.navigation.three;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.my.gank.R;

/**
 * Author: mengyuan
 * Date  : 2021/10/18/4:27 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class Navigation_Activity_3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation_3);

        NavController navController = Navigation.findNavController(this, R.id.fragment_navigation_3);

        NavigationUI.setupActionBarWithNavController(this,navController);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragment_navigation_3);

        return navController.navigateUp();
    }
}
