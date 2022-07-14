package com.my.gank.study.paging.one.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Context;

import com.my.gank.study.paging.one.bean.RoomInfoBean;

/**
 * Author: mengyuan
 * Date  : 2021/10/26/3:32 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */

@Database(entities = {RoomInfoBean.AudioRoomInfo.class}, version = 1, exportSchema = true)
public abstract class Paging_MyDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "paging_my_db.db";

    private static Paging_MyDatabase mInstance;


    public static Paging_MyDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext()
                    , Paging_MyDatabase.class
                    , DATABASE_NAME).build();
        }
        return mInstance;
    }


    public abstract Paging_RoomInfoDao getRoomInfoDao();


}
