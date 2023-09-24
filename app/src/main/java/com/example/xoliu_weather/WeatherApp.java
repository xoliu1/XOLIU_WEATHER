package com.example.xoliu_weather;

import com.baidu.location.LocationClient;
import com.example.library.base.BaseApplication;
import com.example.library.network.NetworkApi;
import com.example.xoliu_weather.db.AppDatabase;
import com.example.xoliu_weather.utils.MVUtils;
import com.tencent.mmkv.MMKV;

public class WeatherApp extends BaseApplication {

    //数据库
    private static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        //使用定位需要同意隐私合规政策
        LocationClient.setAgreePrivacy(true);
        //初始化网络框架
        NetworkApi.init(new NetworkRequiredInfo(this));
        //MMKV初始化
        MMKV.initialize(this);
        //工具类初始化
        MVUtils.getInstance();
        //初始化Room数据库
        db = AppDatabase.getInstance(this);
    }

    public static AppDatabase getDb() {
        return db;
    }
}

