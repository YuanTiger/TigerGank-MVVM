package com.my.gank.test.viewmodel.one;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/7:03 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class ViewModelTest  extends ViewModel {


    private MutableLiveData<Integer> testNum;


    public MutableLiveData<Integer> getTestNum(){
        if(testNum == null){
            testNum = new MutableLiveData<>();
            testNum.setValue(0);
        }
        return  testNum;
    }

}
