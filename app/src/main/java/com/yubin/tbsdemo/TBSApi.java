package com.yubin.tbsdemo;

import android.content.Context;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;

/**
 * author : Yubin.Ying
 * time : 2019/3/21
 */
public class TBSApi {

    private static TBSApi tbsApi;

    public static TBSApi getTbsApi() {
        if (tbsApi == null) {
            synchronized (TBSApi.class) {
                if (tbsApi == null) {
                    tbsApi = new TBSApi();
                }
            }
        }
        return tbsApi;
    }

    public void initTbs(Context context) {//第一步：application的方法
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        //TbsDownloader.needDownload(getApplicationContext(), false);
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                Log.e("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {
                Log.d("app", "onDownloadFinish");
            }

            @Override
            public void onInstallFinish(int i) {
                Log.d("app", "onInstallFinish");
            }

            @Override
            public void onDownloadProgress(int i) {
                Log.d("app", "onDownloadProgress:" + i);
            }
        });
//        QbSdk.initX5Environment(getApplicationContext(),  cb);
        QbSdk.initX5Environment(context, cb);  //二次封装更换
    }
}
