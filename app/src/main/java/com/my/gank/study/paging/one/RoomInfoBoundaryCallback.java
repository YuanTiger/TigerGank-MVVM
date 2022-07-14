package com.my.gank.study.paging.one;


import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.paging.PagedList;

import com.my.gank.study.paging.one.api.Paging_RequestManager;
import com.my.gank.study.paging.one.bean.BaseBean;
import com.my.gank.study.paging.one.bean.RoomInfoBean;
import com.my.gank.study.paging.one.db.Paging_MyDatabase;
import com.my.gank.utils.LogUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author: mengyuan
 * Date  : 2021/10/26/3:41 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class RoomInfoBoundaryCallback extends PagedList.BoundaryCallback<RoomInfoBean.AudioRoomInfo> {


    private Application application;

    public RoomInfoBoundaryCallback(Application application) {
        this.application = application;
    }

    /**
     * 加载第一页数据
     */
    @Override
    public void onZeroItemsLoaded() {
        super.onZeroItemsLoaded();
        getTopData();
    }


    private void getTopData() {
        Paging_RequestManager.getInstance().getApi().getRoomList(0, true, "0", 0, 0).enqueue(new Callback<BaseBean<RoomInfoBean>>() {
            @Override
            public void onResponse(Call<BaseBean<RoomInfoBean>> call, Response<BaseBean<RoomInfoBean>> response) {
                if (response.body() != null && response.body().dataInfo != null && response.body().dataInfo.list != null) {
                    insertRoomListToDb(response.body().dataInfo.list);
                    LogUtils.iTag("YuanTiger", "loadInitial:" + response.body().dataInfo.list.size());
                }
            }

            @Override
            public void onFailure(Call<BaseBean<RoomInfoBean>> call, Throwable t) {

            }
        });
    }


    private void insertRoomListToDb(List<RoomInfoBean.AudioRoomInfo> list) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Paging_MyDatabase.getInstance(application)
                        .getRoomInfoDao()
                        .insertRoomList(list);
            }
        });


    }

    /**
     * 加载第二页数据
     */
    @Override
    public void onItemAtEndLoaded(@NonNull RoomInfoBean.AudioRoomInfo roomInfo) {
        super.onItemAtEndLoaded(roomInfo);

        getTopAfterData(roomInfo);

    }


    private void getTopAfterData(RoomInfoBean.AudioRoomInfo roomInfo) {
        Paging_RequestManager.getInstance().getApi().getRoomList(0, false, "0", 0, 0).enqueue(new Callback<BaseBean<RoomInfoBean>>() {
            @Override
            public void onResponse(Call<BaseBean<RoomInfoBean>> call, Response<BaseBean<RoomInfoBean>> response) {
                if (response.body() != null && response.body().dataInfo != null && response.body().dataInfo.list != null) {
                    insertRoomListToDb(response.body().dataInfo.list);
                    LogUtils.iTag("YuanTiger", "loadInitial:" + response.body().dataInfo.list.size());
                }
            }

            @Override
            public void onFailure(Call<BaseBean<RoomInfoBean>> call, Throwable t) {

            }
        });
    }
}
