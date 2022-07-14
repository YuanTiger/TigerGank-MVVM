package com.my.gank.study.databinding.six;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.my.gank.R;
import com.my.gank.databinding.ActivityDataBinding6Binding;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/6:50 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class DataBindingTestActivity_6 extends AppCompatActivity {


    private ActivityDataBinding6Binding viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_6);


        viewDataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        DataBinding_RyAdapter dataBinding_ryAdapter = new DataBinding_RyAdapter();
        dataBinding_ryAdapter.setIdolList(getDataList());
        viewDataBinding.recyclerView.setAdapter(dataBinding_ryAdapter);


    }


    private List<DataBinding_IdolBean_6> getDataList() {
        List<DataBinding_IdolBean_6> list = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            DataBinding_IdolBean_6 item = new DataBinding_IdolBean_6();
            item.image = "http://pic-api.yindui.net/group1/M00/0B/DA/wKgACmFhoqGEJoQGAAAAAD1ZT4I307.png?x-oss-process=image/resize,m_fixed,w_240,h_240/quality,q_50";
            item.chName = i + "-" + i + "-" + i + "-" + i + "-" + i + "-" + i + "-" + i + "-" + i + "-" + i + "-" + i + "-" + i + "-" + i + "-";
            item.enName = i + "+" + i + "+" + i + "+" + i + "+" + i + "+" + i + "+" + i + "+" + i + "+" + i + "+" + i + "+" + i + "+" + i + "+";

            list.add(item);
        }

        return list;

    }


}
