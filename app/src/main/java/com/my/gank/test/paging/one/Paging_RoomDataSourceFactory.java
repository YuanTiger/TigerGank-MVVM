package com.my.gank.test.paging.one;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.my.gank.test.paging.one.bean.RoomInfoBean;

/**
 * Author: mengyuan
 * Date  : 2021/10/25/2:47 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class Paging_RoomDataSourceFactory extends DataSource.Factory<Integer, RoomInfoBean.AudioRoomInfo> {


    @NonNull
    @Override
    public DataSource<Integer, RoomInfoBean.AudioRoomInfo> create() {
        return new Paging_RoomPageKeyDataSource();
    }
}
