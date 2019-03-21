package com.yubin.tbsdemo;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

/**
 * author : Yubin.Ying
 * time : 2019/3/20
 */
public class App extends Application {

    private static App instance;
    private TBSApi mTBSApi;

    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
        mTBSApi = TBSApi.getTbsApi();
        mTBSApi.initTbs(getApplicationContext());
    }
}
