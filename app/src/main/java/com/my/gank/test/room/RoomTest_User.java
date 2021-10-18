package com.my.gank.test.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Author: mengyuan
 * Date  : 2021/10/15/4:26 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 * User对象
 */
//Entity：表名
@Entity(tableName = "RoomTest_User")
public class RoomTest_User {

    //PrimaryKey：主键
    //autoGenerate：是否自增长
    //ColumnInfo：数据库列名
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id", typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "user_name", typeAffinity = ColumnInfo.TEXT)
    public String userName;

    @ColumnInfo(name = "age", typeAffinity = ColumnInfo.INTEGER)
    public int age;


    public RoomTest_User(int id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    //Ignore：忽略，Room不会使用该构造方法
    @Ignore
    public RoomTest_User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }


    @Ignore
    public RoomTest_User(int id) {
        this.id = id;
    }
}
