package com.my.gank.test.viewmodel.two;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Author: mengyuan
 * Date  : 2021/10/13/2:54 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class SeekBarViewModel  extends ViewModel {

    public MutableLiveData<Integer> seekBarProgress;


    public MutableLiveData<Integer> getSeekProgress(){
        if(seekBarProgress == null){
            seekBarProgress = new MutableLiveData<>();
            seekBarProgress.setValue(0);
        }
        return  seekBarProgress;
    }


}
