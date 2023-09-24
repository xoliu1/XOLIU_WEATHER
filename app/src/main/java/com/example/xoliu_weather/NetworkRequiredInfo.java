package com.example.xoliu_weather;

import android.app.Application;

import com.baidu.location.pb.BuildConfig;
import com.example.library.network.INetworkRequiredInfo;

public class NetworkRequiredInfo implements INetworkRequiredInfo {

    private final Application application;

    public NetworkRequiredInfo(Application application){
        this.application = application;
    }

    /**
     * 版本名
     */
    @Override
    public String getAppVersionName() {
        return "1.0";
        //return BuildConfig.VERSION_NAME;
        //未解决
    }

    /**
     * 版本号
     */
    @Override
    public String getAppVersionCode() {
        return "1.0";
        //未解决
        //return String.valueOf(BuildConfig.VERSION_CODE);
    }

    /**
     * 是否为debug
     */
    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    /**
     * 应用全局上下文
     */
    @Override
    public Application getApplicationContext() {
        return application;
    }
}


