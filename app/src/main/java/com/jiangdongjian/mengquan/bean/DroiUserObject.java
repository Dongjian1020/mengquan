package com.jiangdongjian.mengquan.bean;

import com.droi.sdk.core.DroiExpose;
import com.droi.sdk.core.DroiUser;

/**
 * Created by jiangdongjian on 2017/3/29.
 */

public class DroiUserObject extends DroiUser {
    @DroiExpose
    public String phoneNumber = "";

    @DroiExpose
    private String mNickName = "";

    @DroiExpose
    private int mGender;

    @DroiExpose
    private String mBirthday = "";

    @DroiExpose
    private String mCity = "";

    public String getmNickName() {
        return mNickName;
    }

    public void setmNickName(String mNickName) {
        this.mNickName = mNickName;
    }

    public int getmGender() {
        return mGender;
    }

    public void setmGender(int mGender) {
        this.mGender = mGender;
    }

    public String getmBirthday() {
        return mBirthday;
    }

    public void setmBirthday(String mBirthday) {
        this.mBirthday = mBirthday;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }
}
