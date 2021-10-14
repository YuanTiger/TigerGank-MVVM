package com.my.gank.test.databinding.seven;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Author: mengyuan
 * Date  : 2021/10/14/3:23 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class DataBinding_ViewModel_7 extends ViewModel {


    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;
    private Integer aLast;
    private Integer bLast;


    public MutableLiveData<Integer> getaTeamScore() {
        if (aTeamScore == null) {
            aTeamScore = new MutableLiveData<>();
            aTeamScore.setValue(0);
        }
        return aTeamScore;
    }


    public MutableLiveData<Integer> getbTeamScore() {
        if (bTeamScore == null) {
            bTeamScore = new MutableLiveData<>();
            bTeamScore.setValue(0);
        }
        return bTeamScore;
    }


    public void addNum_A(int i) {
        saveLastScore();
        aTeamScore.setValue(aTeamScore.getValue() + i);
    }

    public void addNum_B(int i) {
        saveLastScore();
        bTeamScore.setValue(bTeamScore.getValue() + i);
    }


    public void revoke() {
        aTeamScore.setValue(aLast);
        bTeamScore.setValue(bLast);
    }

    public void reset() {
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }


    private void saveLastScore() {
        this.aLast = aTeamScore.getValue();
        this.bLast = bTeamScore.getValue();
    }
}
