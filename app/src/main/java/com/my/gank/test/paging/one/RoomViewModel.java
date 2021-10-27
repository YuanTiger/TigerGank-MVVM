package com.my.gank.test.paging.one;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.my.gank.test.paging.one.bean.RoomInfoBean;
import com.my.gank.test.paging.one.db.Paging_MyDatabase;
import com.my.gank.test.paging.one.db.Paging_RoomInfoDao;

/**
 * Author: mengyuan
 * Date  : 2021/10/25/2:56 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class RoomViewModel extends AndroidViewModel {


    public LiveData<PagedList<RoomInfoBean.AudioRoomInfo>> roomList;



    public RoomViewModel(@NonNull Application application) {
        super(application);
        Paging_RoomInfoDao roomInfoDao = Paging_MyDatabase.getInstance(application).getRoomInfoDao();

        roomList = new LivePagedListBuilder<>(roomInfoDao.getRoomList(),50)
                .setBoundaryCallback(new RoomInfoBoundaryCallback(application))
                .build();

    }

    /**
     * 刷新
     */
    public void refresh(){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Paging_MyDatabase.getInstance(getApplication())
                        .getRoomInfoDao()
                        .clear();
            }
        });
    }

}
