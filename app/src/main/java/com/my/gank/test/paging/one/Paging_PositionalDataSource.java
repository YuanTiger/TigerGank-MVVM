package com.my.gank.test.paging.one;

import androidx.annotation.NonNull;
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
public class Paging_PositionalDataSource extends PositionalDataSource<RoomInfoBean.AudioRoomInfo> {


    /**
     * 页面首次加载数据会调用
     */
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<RoomInfoBean.AudioRoomInfo> callback) {
        Paging_RequestManager.getInstance().getApi().getRoomList(0, true, "0", 0, 0).enqueue(new Callback<BaseBean<RoomInfoBean>>() {
            @Override
            public void onResponse(Call<BaseBean<RoomInfoBean>> call, Response<BaseBean<RoomInfoBean>> response) {
                if (response.body() != null && response.body().dataInfo.list != null) {
                    //把数据传递给PageList
                    callback.onResult(response.body().dataInfo.list, response.body().dataInfo.list.size(), response.body().dataInfo.total);
                    LogUtils.iTag("YuanTiger","loadInitial:"+response.body().dataInfo.list.size());
                }
            }

            @Override
            public void onFailure(Call<BaseBean<RoomInfoBean>> call, Throwable t) {

            }
        });
    }


    /**
     * 加载下一页
     */
    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<RoomInfoBean.AudioRoomInfo> callback) {
        Paging_RequestManager.getInstance().getApi().getRoomList(params.startPosition, true, "0", 0, 0).enqueue(new Callback<BaseBean<RoomInfoBean>>() {
            @Override
            public void onResponse(Call<BaseBean<RoomInfoBean>> call, Response<BaseBean<RoomInfoBean>> response) {
                if (response.body() != null && response.body().dataInfo.list != null) {
                    //把数据传递给PageList
                    callback.onResult(response.body().dataInfo.list);
                    LogUtils.iTag("YuanTiger","loadRange:"+response.body().dataInfo.list.size());
                }
            }

            @Override
            public void onFailure(Call<BaseBean<RoomInfoBean>> call, Throwable t) {

            }
        });
    }
}
