package com.my.gank.study.paging.one.bean;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

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

    @Entity(tableName = "paging_room_info")
    public static class AudioRoomInfo {

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "no",typeAffinity = ColumnInfo.INTEGER)
        public int NO;
        @ColumnInfo(name = "room_id",typeAffinity = ColumnInfo.INTEGER)
        public int roomId;
        @ColumnInfo(name = "room_type",typeAffinity = ColumnInfo.INTEGER)
        public int roomType;
        @ColumnInfo(name = "room_name",typeAffinity = ColumnInfo.TEXT)
        public String roomName;
        @ColumnInfo(name = "room_pic",typeAffinity = ColumnInfo.TEXT)
        public String roomPic;

        @Ignore
        public int onlineNum;
        @Ignore
        public int passwordState;
        @Ignore
        public CurrentUserInfo currentUser;
        @Ignore
        //房间当前状态：1女孩多、2等待连接、3有CP、4热闹、5已关注
        public int roomCurrentState;


        @Override
        public boolean equals(@Nullable Object obj) {
            AudioRoomInfo roomInfo = (AudioRoomInfo) obj;
            return roomName.equals(roomInfo.roomName)
                    && roomPic.equals(roomInfo.roomPic)
                    && passwordState == roomInfo.passwordState
                    ;
        }
    }

    public static class CurrentUserInfo {
        public int sex;
    }

}
