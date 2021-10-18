package com.my.gank.test.room.two;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.my.gank.R;
import com.my.gank.databinding.ActivityRoom2Binding;
import com.my.gank.test.room.RoomTest_User;

import java.util.List;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/6:50 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class RoomTestActivity_2 extends AppCompatActivity {


    private ActivityRoom2Binding viewBinding;

    private RoomTest_RyAdapter_2 adapter;

    private RoomTest_UserViewModel roomTest_userViewModel;


    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_room_2);


        viewBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new RoomTest_RyAdapter_2();
        viewBinding.recyclerView.setAdapter(adapter);

        roomTest_userViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(RoomTest_UserViewModel.class);


        roomTest_userViewModel.queryAll().observe(this, new Observer<List<RoomTest_User>>() {
            @Override
            public void onChanged(List<RoomTest_User> roomTest_users) {
                adapter.setUserList(roomTest_users);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void mInsert(View view) {
        RoomTest_User user = new RoomTest_User("YuanTiger", 25);
        RoomTest_User user2 = new RoomTest_User("Kxy", 25);
        RoomTest_User user3 = new RoomTest_User("Sun", 21);
        RoomTest_User user4 = new RoomTest_User("Tony", 12);

        roomTest_userViewModel.insertUser(user, user2, user3, user4);

    }

    public void mDeleteAll(View view) {
        roomTest_userViewModel.deleteAllUser();
    }

    public void mUpdate(View view) {
        RoomTest_User user = new RoomTest_User(1, "1111111", 25);

        roomTest_userViewModel.updateUser(user);
    }

    public void mDelete(View view) {
        RoomTest_User user = new RoomTest_User(1);
        roomTest_userViewModel.deleteUser(user);
    }

}
