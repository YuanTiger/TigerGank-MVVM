package com.my.gank.study.room.two;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.my.gank.study.room.RoomTest_User;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Author: mengyuan
 * Date  : 2021/10/18/11:30 上午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class RoomTest_UserViewModel extends AndroidViewModel {

    private RoomTest_UserRepository repository;


    public RoomTest_UserViewModel(@NonNull @NotNull Application application) {
        super(application);
        repository = new RoomTest_UserRepository(application);
    }


    public void insertUser(RoomTest_User... users) {
        repository.insertUser(users);
    }


    public void deleteUser(RoomTest_User... users) {
        repository.deleteUser(users);
    }


    public void deleteAllUser() {
        repository.deleteAllUser();
    }


    public void updateUser(RoomTest_User... users) {
        repository.updateUser(users);
    }

    public LiveData<List<RoomTest_User>> queryAll() {
        return repository.queryAll();
    }
}
