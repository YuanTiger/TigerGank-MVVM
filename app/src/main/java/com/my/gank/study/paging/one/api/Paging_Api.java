package com.my.gank.study.paging.one.api;

import com.my.gank.study.paging.one.bean.BaseBean;
import com.my.gank.study.paging.one.bean.RoomInfoBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Author: mengyuan
 * Date  : 2021/10/25/2:23 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public interface Paging_Api {

    @GET("linkRecommend?index=0&is_index=true&sex=0&type=0&_imei=035f47991c6d8916&_t=200&_v=10110&_app=3&_s_v=9&_s_n=RedmiNote5&_net=NETWORK_WIFI&_token=3119511_200_1635234582021_2f84874a7d5f6eac&_c=&_at=2&_time=1635314271498")
    Call<BaseBean<RoomInfoBean>> getRoomList(@Query("index") int index, @Query("is_index") boolean isRefresh, @Query("tag_id") String tag_id, @Query("sex") int sex, @Query("type") int type);
}
