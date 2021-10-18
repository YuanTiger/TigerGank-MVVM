package com.my.gank.test.room.two;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.my.gank.test.room.RoomTest_User;

import org.jetbrains.annotations.NotNull;

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

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull @NotNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE roomtest_user ADD COLUMN sex INTEGER NOT NULL DEFAULT 1");
        }
    };


    public static synchronized RoomTest_Database_2 getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(), RoomTest_Database_2.class, DATABASE_NAME)
                    .addMigrations(MIGRATION_1_2)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstance;
    }

    public abstract RoomTest_UserDao_2 getRoomTest_UserDao();
}
