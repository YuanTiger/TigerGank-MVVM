package com.my.gank.test.paging.one.bean;

import androidx.annotation.Nullable;

import java.util.List;

/**
 * Author: mengyuan
 * Date  : 2021/10/25/11:35 上午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class RoomInfoBean {

    //条目总数
    public int total;
    //条目开始下标
    public int index;

    public List<AudioRoomInfo> list;

    public static class AudioRoomInfo {
        public int userId;
        public int roomId;
        //房间类型 1-文字房、2-1v1、3-六麦房、4-10麦房
        public int roomType;
        public String roomName;
        public String roomPic;
        //房主在不在房间
        public boolean online;
        public int onlineNum;
        public List<Integer> tagIds;
        //上锁状态：1有密码，其他无密码
        public int passwordState;
        //是否关注该房间
        public boolean follow;
        public CurrentUserInfo currentUser;
        //房间当前状态：1女孩多、2等待连接、3有CP、4热闹、5已关注
        public int roomCurrentState;
        //门牌id
        public int doorId;
        //足迹状态
        public boolean footprint;
        //是否有红包
        public boolean red;
        //用户照片列表，目前用于扩圈、柜柜
        public List<String> userPicList;


        @Override
        public boolean equals(@Nullable Object obj) {
            AudioRoomInfo roomInfo = (AudioRoomInfo) obj;
            return roomName.equals(roomInfo.roomName)
                    && roomPic.equals(roomInfo.roomPic)
                    && red == roomInfo.red
                    && passwordState == roomInfo.passwordState
                    ;
        }
    }

    public static class CurrentUserInfo {
        public int sex;
    }

}
