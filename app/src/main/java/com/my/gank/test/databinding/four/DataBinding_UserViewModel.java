package com.my.gank.test.databinding.four;

import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.my.gank.BR;
import com.my.gank.utils.LogUtils;

/**
 * Author: mengyuan
 * Date  : 2021/10/14/10:51 上午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class DataBinding_UserViewModel extends BaseObservable {

    public DataBinding_User user;


    public DataBinding_UserViewModel() {
        this.user = new DataBinding_User("YuanTiger4");
    }

    @Bindable
    public String getUserName() {
        return user.userName;
    }

    public void setUserName(String userNameText) {
        if (TextUtils.isEmpty(userNameText) || user == null || userNameText.equals(user.userName)) {
            return;
        }
        LogUtils.iTag("YuanTiger", "username changed:" + userNameText);
        user.userName = userNameText;
        notifyPropertyChanged(BR.userName);
    }

}
