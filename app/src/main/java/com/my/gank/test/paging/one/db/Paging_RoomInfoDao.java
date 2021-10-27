package com.my.gank.test.paging.one.db;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.my.gank.test.paging.one.bean.RoomInfoBean;

import java.util.List;

/**
 * Author: mengyuan
 * Date  : 2021/10/26/3:38 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
@Dao
public interface Paging_RoomInfoDao {

    @Insert
    void insertRoomList(List<RoomInfoBean.AudioRoomInfo> roomInfoList);

    @Query("DELETE FROM paging_room_info")
    void clear();


    @Query("SELECT * FROM paging_room_info")
    DataSource.Factory<Integer, RoomInfoBean.AudioRoomInfo> getRoomList();
}
