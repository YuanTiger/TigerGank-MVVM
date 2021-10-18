package com.my.gank.test.room.two;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.my.gank.test.room.RoomTest_User;

/**
 * Author: mengyuan
 * Date  : 2021/10/15/4:39 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
@Database(entities = {RoomTest_User.class}, version = 1, exportSchema = false)
public abstract class RoomTest_Database_2 extends RoomDatabase {

    private static final String DATABASE_NAME = "room_test_db.db";

    private static RoomTest_Database_2 mInstance;

    public static synchronized RoomTest_Database_2 getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(), RoomTest_Database_2.class, DATABASE_NAME).build();
        }
        return mInstance;
    }

    public abstract RoomTest_UserDao_2 getRoomTest_UserDao();
}
