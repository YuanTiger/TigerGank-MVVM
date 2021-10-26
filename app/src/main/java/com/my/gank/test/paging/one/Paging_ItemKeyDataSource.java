package com.my.gank.test.paging.one;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.PositionalDataSource;

import com.my.gank.test.paging.one.api.Paging_RequestManager;
import com.my.gank.test.paging.one.bean.BaseBean;
import com.my.gank.test.paging.one.bean.RoomInfoBean;
import com.my.gank.utils.LogUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author: mengyuan
 * Date  : 2021/10/25/2:37 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class Paging_ItemKeyDataSource extends ItemKeyedDataSource<Integer, RoomInfoBean.AudioRoomInfo> {


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<RoomInfoBean.AudioRoomInfo> callback) {
        Paging_RequestManager.getInstance().getApi().getRoomList(0, true, "0", 0, 0).enqueue(new Callback<BaseBean<RoomInfoBean>>() {
            @Override
            public void onResponse(Call<BaseBean<RoomInfoBean>> call, Response<BaseBean<RoomInfoBean>> response) {
                if (response.body() != null && response.body().dataInfo.list != null) {
                    //把数据传递给PageList
                    callback.onResult(response.body().dataInfo.list);
                    LogUtils.iTag("YuanTiger", "loadInitial:" + response.body().dataInfo.list.size());
                }
            }

            @Override
            public void onFailure(Call<BaseBean<RoomInfoBean>> call, Throwable t) {

            }
        });
    }


    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<RoomInfoBean.AudioRoomInfo> callback) {
        Paging_RequestManager.getInstance().getApi().getRoomList(0, false, "0", 0, 0).enqueue(new Callback<BaseBean<RoomInfoBean>>() {
            @Override
            public void onResponse(Call<BaseBean<RoomInfoBean>> call, Response<BaseBean<RoomInfoBean>> response) {
                if (response.body() != null && response.body().dataInfo.list != null) {
                    //把数据传递给PageList
                    callback.onResult(response.body().dataInfo.list);
                    LogUtils.iTag("YuanTiger", "loadInitial:" + response.body().dataInfo.list.size());
                }
            }

            @Override
            public void onFailure(Call<BaseBean<RoomInfoBean>> call, Throwable t) {

            }
        });
    }


    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<RoomInfoBean.AudioRoomInfo> callback) {

    }


    @NonNull
    @Override
    public Integer getKey(@NonNull RoomInfoBean.AudioRoomInfo item) {
        return null;
    }
}
