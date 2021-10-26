package com.my.gank.test.paging.one;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
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
public class Paging_RoomPageKeyDataSource extends PageKeyedDataSource<Integer, RoomInfoBean.AudioRoomInfo> {



    /**
     * 加载第一页
     *
     * @param params
     * @param callback
     */
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback callback) {
        Paging_RequestManager.getInstance().getApi().getRoomList(0, true, "0", 0, 0).enqueue(new Callback<BaseBean<RoomInfoBean>>() {
            @Override
            public void onResponse(Call<BaseBean<RoomInfoBean>> call, Response<BaseBean<RoomInfoBean>> response) {
                if (response.body() != null && response.body().dataInfo.list != null) {
                    //把数据传递给PageList
                    callback.onResult(response.body().dataInfo.list, response.body().dataInfo.list.size(), response.body().dataInfo.total);
                    LogUtils.iTag("YuanTiger", "loadInitial:" + response.body().dataInfo.list.size());
                }
            }

            @Override
            public void onFailure(Call<BaseBean<RoomInfoBean>> call, Throwable t) {

            }
        });
    }


    @Override
    public void loadBefore(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }


    @Override
    public void loadAfter(@NonNull LoadParams params, @NonNull LoadCallback callback) {
        Paging_RequestManager.getInstance().getApi().getRoomList(0, false, "0", 0, 0).enqueue(new Callback<BaseBean<RoomInfoBean>>() {
            @Override
            public void onResponse(Call<BaseBean<RoomInfoBean>> call, Response<BaseBean<RoomInfoBean>> response) {
                if (response.body() != null) {
                    //把数据传递给PageList
                    callback.onResult(response.body().dataInfo.list, ((Integer) params.key) + response.body().dataInfo.list.size());
                    LogUtils.iTag("YuanTiger", "loadRange:" + response.body().dataInfo.list.size());
                }
            }

            @Override
            public void onFailure(Call<BaseBean<RoomInfoBean>> call, Throwable t) {

            }
        });
    }
}
