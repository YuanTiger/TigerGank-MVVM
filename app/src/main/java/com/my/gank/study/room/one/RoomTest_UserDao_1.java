package com.my.gank.study.room.one;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.my.gank.study.room.RoomTest_User;

import java.util.List;

/**
 * Author: mengyuan
 * Date  : 2021/10/15/4:35 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
@Dao
public interface RoomTest_UserDao_1 {

    @Insert
    void insertUser(RoomTest_User... users);


    @Delete
    void deleteUser(RoomTest_User... users);

    @Update
    void updateUser(RoomTest_User... users);

    @Query("SELECT * FROM roomtest_user")
    List<RoomTest_User> getAllUser();


    @Query("SELECT * FROM roomtest_user WHERE user_id = :id")
    List<RoomTest_User> getUserById(int id);
}
