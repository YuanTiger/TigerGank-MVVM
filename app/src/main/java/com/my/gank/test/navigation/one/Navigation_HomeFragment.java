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
public class Navigation_HomeFragment extends Fragment {


    public Navigation_HomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button btJump = getView().findViewById(R.id.bt_jump_detail);
        btJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Navigation_HomeFragmentArgs.Builder()
                        .setUserName("Qwert")
                        .setAge(18)
                        .build()
                        .toBundle();

                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_homeFragment_to_detailFragment, bundle);
            }
        });
    }
}
