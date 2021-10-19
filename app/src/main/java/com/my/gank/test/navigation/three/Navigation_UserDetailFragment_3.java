package com.my.gank.test.navigation.three;

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
import com.my.gank.test.navigation.one.Navigation_HomeFragmentArgs;

/**
 * Author: mengyuan
 * Date  : 2021/10/18/4:31 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class Navigation_UserDetailFragment_3 extends Fragment {

    public Navigation_UserDetailFragment_3() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_detail_3, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Navigation_HomeFragmentArgs args = Navigation_HomeFragmentArgs.fromBundle(getArguments());
//        String userName = args.getUserName();
//        int age = args.getAge();


        Button btJump = getView().findViewById(R.id.bt_jump_home);

        Bundle arguments = getArguments();
        if(arguments != null){
            String user_name = arguments.getString("user_name");
            btJump.setText(user_name);
        }

        btJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_detailFragment_to_homeFragment);
            }
        });
    }
}
