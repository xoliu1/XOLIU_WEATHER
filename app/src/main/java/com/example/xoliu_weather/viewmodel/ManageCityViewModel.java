package com.example.xoliu_weather.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.library.base.BaseViewModel;
import com.example.xoliu_weather.db.bean.MyCity;
import com.example.xoliu_weather.repository.CityRepository;

import java.util.List;

public class ManageCityViewModel extends BaseViewModel {

    public MutableLiveData<List<MyCity>> listMutableLiveData = new MutableLiveData<>();

    /**
     * 获取我的城市所有城市数据
     */
    public void getAllCityData() {
        CityRepository.getInstance().getMyCityData(listMutableLiveData);
    }

    /**
     * 添加我的城市数据，在定位之后添加数据
     */
    public void addMyCityData(String cityName) {
        CityRepository.getInstance().addMyCityData(new MyCity(cityName));
    }
    /**
     * 删除我的城市数据
     */
    public void deleteMyCityData(MyCity myCity) {
        CityRepository.getInstance().deleteMyCityData(myCity);
    }

    /**
     * 删除我的城市数据
     */
    public void deleteMyCityData(String cityName) {
        CityRepository.getInstance().deleteMyCityData(cityName);
    }

}
