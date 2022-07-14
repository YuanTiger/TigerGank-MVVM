package com.my.gank.study.paging.one;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.my.gank.R;
import com.my.gank.base.App;
import com.my.gank.databinding.ItemPagingRoomBinding;
import com.my.gank.study.paging.one.bean.RoomInfoBean;

/**
 * Author: mengyuan
 * Date  : 2021/10/25/3:05 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class Paging_RoomPageListAdapter extends PagedListAdapter<RoomInfoBean.AudioRoomInfo, Paging_RoomPageListAdapter.RoomHolder> {


    //差分：只更新需要更新的元素，而不是刷新所有元素
    private static final DiffUtil.ItemCallback<RoomInfoBean.AudioRoomInfo> DIFF_CALLBACK = new DiffUtil.ItemCallback<RoomInfoBean.AudioRoomInfo>() {
        /**
         * 两个对象是否是同一个对象
         */
        @Override
        public boolean areItemsTheSame(@NonNull RoomInfoBean.AudioRoomInfo oldItem, @NonNull RoomInfoBean.AudioRoomInfo newItem) {
            return oldItem == newItem;
        }

        /**
         * 两个对象的内容是否相同
         */
        @Override
        public boolean areContentsTheSame(@NonNull RoomInfoBean.AudioRoomInfo oldItem, @NonNull RoomInfoBean.AudioRoomInfo newItem) {
            return oldItem.equals(newItem);
        }
    };


    protected Paging_RoomPageListAdapter() {
        super(DIFF_CALLBACK);
    }


    @NonNull
    @Override
    public RoomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPagingRoomBinding viewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_paging_room, parent, false);
        return new RoomHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomHolder holder, int position) {
        holder.refreshData(getItem(position), position);
    }


    //--------------------------Holder--------------------------
    //--------------------------Holder--------------------------
    //--------------------------Holder--------------------------
    public class RoomHolder extends RecyclerView.ViewHolder {
        private ItemPagingRoomBinding binding;

        public RoomHolder(ItemPagingRoomBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void refreshData(RoomInfoBean.AudioRoomInfo roomInfo, int position) {
            //房间当前状态：1女孩多、2等待连接、3有CP、4热闹、5已关注
            //优先级：等待连麦>关注>我的CP> 妹子多>特别热闹
            switch (roomInfo.roomCurrentState) {
                case 1:
                    binding.tvRoomState.setText("妹子多");
                    break;
                case 2://1v1连麦
                    if (roomInfo.currentUser == null) {
                        binding.tvRoomState.setText("");
                    } else if (roomInfo.currentUser.sex == 1) {
                        binding.tvRoomState.setText("房主男");
                    } else if (roomInfo.currentUser.sex == 2) {
                        binding.tvRoomState.setText("房主女");
                    } else {
                        binding.tvRoomState.setText("");
                    }
                    break;
                case 3:
                    binding.tvRoomState.setText("你的CP");
                    break;
                case 4:
                    binding.tvRoomState.setText("热闹");
                    break;
                case 5:
                    binding.tvRoomState.setText("你的关注");
                    break;
                default:
                    binding.tvRoomState.setText("");
                    break;
            }
            //房间类型1v1
            if (roomInfo.roomType == 2) {
                //隐藏房间人数状态图
                binding.ivRoomOnlineNumState.setVisibility(View.INVISIBLE);
            }
            //房间标签
            binding.tvRoomTag.setVisibility(View.GONE);
            //房间头像
            Glide.with(App.context).load(roomInfo.roomPic).into(binding.ivRoomPic);
            //在线人数
            binding.tvOnlineNum.setText(String.valueOf(roomInfo.onlineNum));
            //在线人数状态
            binding.ivRoomOnlineNumState.setVisibility(View.INVISIBLE);
            //房间名称
            binding.tvRoomName.setText(roomInfo.roomName);

        }


    }
}
