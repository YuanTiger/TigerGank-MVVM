package com.my.gank.test.databinding.five;

import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.my.gank.BR;
import com.my.gank.test.databinding.four.DataBinding_User;
import com.my.gank.utils.LogUtils;

/**
 * Author: mengyuan
 * Date  : 2021/10/14/10:51 上午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class DataBinding_UserViewModel_5 {

    //ObservableField：双向绑定
    public ObservableField<DataBinding_User_5> userObservableField;


    public DataBinding_UserViewModel_5() {
        DataBinding_User_5 user = new DataBinding_User_5("YuanTiger5");
        userObservableField = new ObservableField<>();
        userObservableField.set(user);

    }


    public String getUserName() {
        return userObservableField.get().userName;
    }

    public void setUserName(String userNameText) {
        if (TextUtils.isEmpty(userNameText) || userObservableField == null || userNameText.equals(userObservableField.get().userName)) {
            return;
        }
        userObservableField.get().userName = userNameText;
        LogUtils.iTag("YuanTiger", "username changed-5:" + userNameText);
    }

}
