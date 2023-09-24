package com.example.xoliu_weather.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.library.base.BaseViewModel;
import com.example.xoliu_weather.db.bean.BingResponse;
import com.example.xoliu_weather.db.bean.Province;
import com.example.xoliu_weather.repository.BingRepository;
import com.example.xoliu_weather.repository.CityRepository;

import java.util.List;

public class SplashViewModel extends BaseViewModel {
    //完成对必应每日一图的获取
    public MutableLiveData<BingResponse> bingResponseMutableLiveData = new MutableLiveData<>();

    public void bing() {
        BingRepository.getInstance().bing(bingResponseMutableLiveData, failed);
    }


    public MutableLiveData<List<Province>> listMutableLiveData = new MutableLiveData<>();

    /**
     * 添加城市数据
     */
    public void addCityData(List<Province> provinceList) {
        CityRepository.getInstance().addCityData(provinceList);
    }

    /**
     * 获取所有城市数据
     */
    public void getAllCityData() {
        CityRepository.getInstance().getCityData(listMutableLiveData);
    }
}

