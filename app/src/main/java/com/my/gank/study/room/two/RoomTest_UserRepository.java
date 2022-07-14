package com.my.gank.study.room.two;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.my.gank.study.room.RoomTest_User;

import java.util.List;

/**
 * Author: mengyuan
 * Date  : 2021/10/18/11:30 上午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class RoomTest_UserRepository {

    private RoomTest_UserDao_2 userDao;

    public RoomTest_UserRepository(Context context) {
        RoomTest_Database_2 instance = RoomTest_Database_2.getInstance(context);
        userDao = instance.getRoomTest_UserDao();
    }

    public void insertUser(RoomTest_User... user) {
        new InsertUserTask(userDao).execute(user);
    }


    public void deleteUser(RoomTest_User... user) {
        new DeleteUserTask(userDao).execute(user);
    }


    public void deleteAllUser() {
        new DeleteAllUserTask(userDao).execute();
    }


    public void updateUser(RoomTest_User... user) {
        new UpdateUserTask(userDao).execute(user);

    }

    public LiveData<List<RoomTest_User>> queryAll() {
        return userDao.getAllUser();
    }


    //--------------------------Task--------------------------
    //--------------------------Task--------------------------
    //--------------------------Task--------------------------
    class InsertUserTask extends AsyncTask<RoomTest_User, Void, Void> {


        private RoomTest_UserDao_2 userDao;

        public InsertUserTask(RoomTest_UserDao_2 userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(RoomTest_User... users) {
            userDao.insertUser(users);
            return null;
        }
    }


    class UpdateUserTask extends AsyncTask<RoomTest_User, Void, Void> {


        private RoomTest_UserDao_2 userDao;

        public UpdateUserTask(RoomTest_UserDao_2 userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(RoomTest_User... users) {
            userDao.updateUser(users);
            return null;
        }
    }


    class DeleteUserTask extends AsyncTask<RoomTest_User, Void, Void> {


        private RoomTest_UserDao_2 userDao;

        public DeleteUserTask(RoomTest_UserDao_2 userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(RoomTest_User... users) {
            userDao.deleteUser(users);
            return null;
        }
    }

    class DeleteAllUserTask extends AsyncTask<Void, Void, Void> {


        private RoomTest_UserDao_2 userDao;

        public DeleteAllUserTask(RoomTest_UserDao_2 userDao) {
            this.userDao = userDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            userDao.deleteAllUser();
            return null;
        }
    }

}
