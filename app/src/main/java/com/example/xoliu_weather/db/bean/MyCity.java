package com.example.xoliu_weather.db.bean;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
//我的城市数据实体类
@Entity
public class MyCity {

    @NonNull
    @PrimaryKey
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Ignore
    public MyCity(String cityName) {
        this.cityName = cityName;
    }

    public MyCity() {}
}

