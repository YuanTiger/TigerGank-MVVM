package com.my.gank.test.room.two;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.my.gank.R;
import com.my.gank.databinding.ItemRoom2Binding;
import com.my.gank.test.room.RoomTest_User;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Author: mengyuan
 * Date  : 2021/10/14/2:32 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class RoomTest_RyAdapter_2 extends RecyclerView.Adapter<RoomTest_RyAdapter_2.MyViewHolder> {


    private List<RoomTest_User> userList;


    public void setUserList(List<RoomTest_User> idolList) {
        this.userList = idolList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemRoom2Binding viewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_room_2, parent, false);
        return new MyViewHolder(viewBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.binding.setUser(userList.get(position));
    }


    @Override
    public int getItemCount() {
        return userList == null ? 0 : userList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ItemRoom2Binding binding;

        public MyViewHolder(ItemRoom2Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
