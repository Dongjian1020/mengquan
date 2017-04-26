package com.jiangdongjian.mengquan.app;

import android.app.Application;
import android.content.Context;

import com.droi.sdk.core.DroiObject;
import com.droi.sdk.feedback.DroiFeedback;
import com.droi.sdk.news.DroiNews;
import com.droi.sdk.news.app.AppApplication;
import com.droi.sdk.selfupdate.DroiUpdate;
import com.jiangdongjian.mengquan.bean.DroiUserObject;

/**
 * Created by jiangdongjian on 2017/3/24.
 */

public class MyApp extends AppApplication {
    public static final String MEDIA_ID = "a9044b490";
    public static final String SLOT_ID_SMALL = "s3921473a";
    public static final String SLOT_ID_BIG = "s9664cfde";

    @Override
    public void onCreate() {
        super.onCreate();
        initNewsSDK(getApplicationContext());
        initDroiUser();
    }
    public void initDroiUser(){
        DroiObject.registerCustomClass(DroiUserObject.class);
        DroiFeedback.initialize(this);
        DroiUpdate.initialize(this);
    }

    public static void initNewsSDK(Context context){
        DroiNews.initialize(context, MEDIA_ID, true);
        DroiNews.registerAdSlot(DroiNews.AD_STYLE_BIG_IMAGE, SLOT_ID_BIG);
        DroiNews.registerAdSlot(DroiNews.AD_STYLE_SMALL_IMAGE, SLOT_ID_SMALL);
    }

}
