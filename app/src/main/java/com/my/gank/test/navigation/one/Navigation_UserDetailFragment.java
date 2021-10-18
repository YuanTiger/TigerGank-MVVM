package com.my.gank.test.navigation.one;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.my.gank.R;

/**
 * Author: mengyuan
 * Date  : 2021/10/18/4:31 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class Navigation_UserDetailFragment extends Fragment {

    public Navigation_UserDetailFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_detail_1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button btJump = getView().findViewById(R.id.bt_jump_home);
        btJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_detailFragment_to_homeFragment);
            }
        });
    }
}
