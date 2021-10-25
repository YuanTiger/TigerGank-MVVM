package com.my.gank.test.paging.one;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.my.gank.R;
import com.my.gank.databinding.ActivityPaging1Binding;
import com.my.gank.test.paging.one.bean.RoomInfoBean;

/**
 * Author: mengyuan
 * Date  : 2021/10/25/11:27 上午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class Paging_Activity_1 extends AppCompatActivity {

    private ActivityPaging1Binding viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_paging_1);

        viewDataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));

        Paging_RoomPageListAdapter adapter = new Paging_RoomPageListAdapter(this);
        viewDataBinding.recyclerView.setAdapter(adapter);


        RoomViewModel roomViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(RoomViewModel.class);

        roomViewModel.roomList.observe(this, new Observer<PagedList<RoomInfoBean.AudioRoomInfo>>() {
            @Override
            public void onChanged(PagedList<RoomInfoBean.AudioRoomInfo> audioRoomInfoList) {
                adapter.setRoomList(audioRoomInfoList);
                adapter.notifyDataSetChanged();
            }
        });


    }
}
