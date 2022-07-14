package com.my.gank.study.databinding.one;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Author: mengyuan
 * Date  : 2021/10/13/3:32 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class EventHandleListener {

    private Context context;


    public EventHandleListener(Context context){
        this.context = context;
    }

    public void buttonOnClick(View view){
        Toast.makeText(context,"喜欢",Toast.LENGTH_SHORT).show();
    }

}
