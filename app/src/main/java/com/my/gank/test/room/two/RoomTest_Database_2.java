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
@Database(entities = {RoomTest_User.class}, version = 3, exportSchema = true)
public abstract class RoomTest_Database_2 extends RoomDatabase {

    private static final String DATABASE_NAME = "room_test_db.db";

    private static RoomTest_Database_2 mInstance;

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull @NotNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE roomtest_user ADD COLUMN sex INTEGER NOT NULL DEFAULT 1");
        }
    };

    /**
     * DB销毁重建策略，模拟字段类型变更
     * 1、创建新的数据库临时表，并将字段类型更改为最新的字段类型；
     * 2、从原表中复制数据；
     * 3、将临时表的表名改为原表名。
     */
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull @NotNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS temp_room_test_user (" +
                    "`user_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "`user_name` TEXT," +
                    " `age` INTEGER NOT NULL, " +
                    "`sex` TEXT DEFAULT 'M')"
            );

            database.execSQL("INSERT INTO temp_room_test_user(user_name,age,sex) SELECT user_name,age,sex FROM RoomTest_User");

            database.execSQL("DROP TABLE RoomTest_User");

            database.execSQL("ALTER TABLE temp_room_test_user RENAME TO RoomTest_User");
        }
    };

    public static synchronized RoomTest_Database_2 getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(), RoomTest_Database_2.class, DATABASE_NAME)
                    .addMigrations(MIGRATION_1_2,MIGRATION_2_3)
                    .createFromAsset("test/room_test_user_pre.db")
                    .build();
        }
        return mInstance;
    }

    public abstract RoomTest_UserDao_2 getRoomTest_UserDao();
}
