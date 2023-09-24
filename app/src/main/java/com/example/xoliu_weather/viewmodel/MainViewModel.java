package com.example.xoliu_weather.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.library.base.BaseViewModel;
import com.example.xoliu_weather.db.bean.AirResponse;
import com.example.xoliu_weather.db.bean.DailyResponse;
import com.example.xoliu_weather.db.bean.HourlyResponse;
import com.example.xoliu_weather.db.bean.LifestyleResponse;
import com.example.xoliu_weather.db.bean.MyCity;
import com.example.xoliu_weather.db.bean.NowResponse;
import com.example.xoliu_weather.db.bean.Province;
import com.example.xoliu_weather.db.bean.SearchCityResponse;
import com.example.xoliu_weather.repository.CityRepository;
import com.example.xoliu_weather.repository.SearchCityRepository;
import com.example.xoliu_weather.repository.WeatherRepository;

import java.util.List;

/**
 * 主页面ViewModel
 */
public class MainViewModel extends BaseViewModel {

    public MutableLiveData<SearchCityResponse> searchCityResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<NowResponse> nowResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<DailyResponse> dailyResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<LifestyleResponse> lifestyleResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Province>> cityMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<HourlyResponse> hourlyResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<AirResponse> airResponseMutableLiveData = new MutableLiveData<>();

    /**
     * 搜索城市
     *
     * @param cityName 城市名称
     */
    public void searchCity(String cityName) {
        SearchCityRepository.getInstance().searchCity(searchCityResponseMutableLiveData, failed, cityName);
    }

    /**
     * 实况天气
     *
     * @param cityId 城市ID
     */
    public void nowWeather(String cityId) {
        WeatherRepository.getInstance().nowWeather(nowResponseMutableLiveData, failed, cityId);
    }

    /**
     * 天气预报
     *
     * @param cityId 城市ID
     */
    public void dailyWeather(String cityId) {
        WeatherRepository.getInstance().dailyWeather(dailyResponseMutableLiveData, failed, cityId);
    }

    /**
     * 生活指数
     *
     * @param cityId 城市ID
     */
    public void lifestyle(String cityId) {
        WeatherRepository.getInstance().lifestyle(lifestyleResponseMutableLiveData, failed, cityId);
    }

    /**
     * 获取行政区数据
     */
    public void getAllCity() {
        CityRepository.getInstance().getCityData(cityMutableLiveData);
    }

    /**
     * 逐小时天气预报
     *
     * @param cityId 城市ID
     */
    public void hourlyWeather(String cityId) {
        WeatherRepository.getInstance().hourlyWeather(hourlyResponseMutableLiveData, failed, cityId);
    }

    /**
     * 逐小时天气预报
     *
     * @param cityId 城市ID
     */
    public void airWeather(String cityId) {
        WeatherRepository.getInstance().airWeather(airResponseMutableLiveData, failed, cityId);
    }

    /**
     * 添加我的城市数据，在定位之后添加数据
     */
    public void addMyCityData(String cityName) {
        MyCity myCity = new MyCity(cityName);
        CityRepository.getInstance().addMyCityData(myCity);
    }
}
