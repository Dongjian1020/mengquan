package com.jiangdongjian.mengquan.bean;

import com.droi.sdk.core.DroiExpose;
import com.droi.sdk.core.DroiUser;

/**
 * Created by jiangdongjian on 2017/3/29.
 */

public class DroiUserObject extends DroiUser {
    @DroiExpose
    public String phoneNumber;
}
