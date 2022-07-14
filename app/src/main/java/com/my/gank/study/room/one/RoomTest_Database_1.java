package com.my.gank.study.room.one;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.my.gank.study.room.RoomTest_User;

/**
 * Author: mengyuan
 * Date  : 2021/10/15/4:39 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
@Database(entities = {RoomTest_User.class}, version = 1, exportSchema = false)
public abstract class RoomTest_Database_1 extends RoomDatabase {

    private static final String DATABASE_NAME = "room_test_db.db";

    private static RoomTest_Database_1 mInstance;

    public static synchronized RoomTest_Database_1 getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(), RoomTest_Database_1.class, DATABASE_NAME).build();
        }
        return mInstance;
    }

    public abstract RoomTest_UserDao_1 getRoomTest_UserDao();
}
