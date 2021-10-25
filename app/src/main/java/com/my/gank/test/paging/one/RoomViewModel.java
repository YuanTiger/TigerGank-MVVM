package com.my.gank.test.paging.one;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.my.gank.test.paging.one.bean.RoomInfoBean;

/**
 * Author: mengyuan
 * Date  : 2021/10/25/2:56 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class RoomViewModel extends ViewModel {


    public LiveData<PagedList<RoomInfoBean.AudioRoomInfo>> roomList;

    public RoomViewModel(){
        PagedList.Config config = new PagedList.Config.Builder()
                //设置控件占位
                .setEnablePlaceholders(false)
                //设置每一页有多少条数据
                .setPageSize(47)
                //设置距离底部还有多少条数据时，开始加载下一页
                .setPrefetchDistance(2)
                //设置首次加载的数量
                //.setInitialLoadSizeHint(50)
                //设置一共有多少页
                .setMaxSize(655535)
                .build();
        roomList = new LivePagedListBuilder<>(new Paging_RoomDataSourceFactory(),config).build();
    }
}
