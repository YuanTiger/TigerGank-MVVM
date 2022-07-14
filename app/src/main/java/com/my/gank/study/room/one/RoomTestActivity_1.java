package com.my.gank.study.room.one;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.my.gank.R;
import com.my.gank.databinding.ActivityRoom1Binding;
import com.my.gank.study.room.RoomTest_User;

import java.util.List;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/6:50 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class RoomTestActivity_1 extends AppCompatActivity {


    private ActivityRoom1Binding viewBinding;

    private RoomTest_UserDao_1 roomTest_userDao;

    private RoomTest_RyAdapter_1 adapter;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_room_1);


        viewBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new RoomTest_RyAdapter_1();
        viewBinding.recyclerView.setAdapter(adapter);

        RoomTest_Database_1 instance = RoomTest_Database_1.getInstance(this);
        roomTest_userDao = instance.getRoomTest_UserDao();

    }


    public void mInsert(View view) {
        RoomTest_User user = new RoomTest_User("YuanTiger", 25);
        RoomTest_User user2 = new RoomTest_User("Kxy", 25);
        RoomTest_User user3 = new RoomTest_User("Sun", 21);
        RoomTest_User user4 = new RoomTest_User("Tony", 12);

        new InsertUserTask(roomTest_userDao).execute(user,user2,user3,user4);


    }

    public void mDelete(View view) {
        RoomTest_User user = new RoomTest_User(5);

        new DeleteUserTask(roomTest_userDao).execute(user);

    }

    public void mUpdate(View view) {
        RoomTest_User user = new RoomTest_User(3,"YuanTiger_2", 25);

        new UpdateUserTask(roomTest_userDao).execute(user);

    }

    public void mQuery(View view) {
        new QueryAllUserTask(roomTest_userDao).execute();
    }


    //--------------------------Task--------------------------
    //--------------------------Task--------------------------
    //--------------------------Task--------------------------
    class InsertUserTask extends AsyncTask<RoomTest_User, Void, Void> {


        private RoomTest_UserDao_1 userDao;

        public InsertUserTask(RoomTest_UserDao_1 userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(RoomTest_User... users) {
            userDao.insertUser(users);
            return null;
        }
    }


    class UpdateUserTask extends AsyncTask<RoomTest_User, Void, Void> {


        private RoomTest_UserDao_1 userDao;

        public UpdateUserTask(RoomTest_UserDao_1 userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(RoomTest_User... users) {
            userDao.updateUser(users);
            return null;
        }
    }


    class DeleteUserTask extends AsyncTask<RoomTest_User, Void, Void> {


        private RoomTest_UserDao_1 userDao;

        public DeleteUserTask(RoomTest_UserDao_1 userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(RoomTest_User... users) {
            userDao.deleteUser(users);
            return null;
        }
    }


    class QueryAllUserTask extends AsyncTask<Void, Void, Void> {

        private RoomTest_UserDao_1 userDao;

        public QueryAllUserTask(RoomTest_UserDao_1 userDao) {
            this.userDao = userDao;
        }

        /**
         * 子线程操作
         */
        @Override
        protected Void doInBackground(Void... users) {
            List<RoomTest_User> allUser = userDao.getAllUser();
            adapter.setUserList(allUser);
            return null;
        }

        /**
         * 主线程操作
         */
        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            adapter.notifyDataSetChanged();

        }


    }

}
