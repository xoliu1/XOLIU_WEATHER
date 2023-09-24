package com.example.xoliu_weather;

import static com.example.xoliu_weather.Constant.API_KEY;

import com.example.xoliu_weather.db.bean.AirResponse;
import com.example.xoliu_weather.db.bean.BingResponse;
import com.example.xoliu_weather.db.bean.DailyResponse;
import com.example.xoliu_weather.db.bean.HourlyResponse;
import com.example.xoliu_weather.db.bean.LifestyleResponse;
import com.example.xoliu_weather.db.bean.NowResponse;
import com.example.xoliu_weather.db.bean.SearchCityResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 在MVVM框架中，是Model + View + ViewModel的模式，
 * Model我们之前已经写好了，就是SearchCityResponse，我们的搜索城市数据实体类，
 * 那么View表示视图，就是我们的Activity，
 * 而ViewModel就是负责连接View，所以在ViewModel中需要获取Model，拿到数据给到View，
 * 而如果直接在ViewModel中请求网络又比较臃肿，因此再拆分一下，在ViewModel使用Repository，作为数据处理的方式
 */
/**
 * API服务接口
 */
public interface ApiService {

    /**
     * 搜索城市  模糊搜索，国内范围 返回10条数据
     *
     * @param location 城市名
     * @return NewSearchCityResponse 搜索城市数据返回
     */
    @GET("/v2/city/lookup?key=" + API_KEY + "&range=cn")
    //https://geoapi.qweather.com/v2/city/lookup?location=beij&key=cc09e46218ba4324aadb9fbe15a7eb1c
    Observable<SearchCityResponse> searchCity(@Query("location") String location);

    /**最近七天天气数据*/
    /**
     * @param location 城市id
     * @return 返回天气预报数据 DailyResponse
     */
    @GET("/v7/weather/7d?key=" + API_KEY)
    Observable<DailyResponse> dailyWeather(@Query("location") String location);

    /**实况天气*/
    @GET("/v7/weather/now?key=" + API_KEY)//缺少location,先用北京垫着
    Observable<NowResponse> nowWeather(@Query("location") String location);


    /**
     * 生活指数
     *
     * @param type     可以控制定向获取那几项数据 全部数据 0, 运动指数	1 ，洗车指数	2 ，穿衣指数	3 ，
     *                 钓鱼指数	4 ，紫外线指数  5 ，旅游指数  6，花粉过敏指数	7，舒适度指数	8，
     *                 感冒指数	9 ，空气污染扩散条件指数	10 ，空调开启指数	 11 ，太阳镜指数	12 ，
     *                 化妆指数  13 ，晾晒指数  14 ，交通指数  15 ，防晒指数	16
     * @param location 城市id
     * @return LifestyleResponse 生活指数数据返回
     */
    @GET("/v7/indices/1d?key=" + API_KEY)
    Observable<LifestyleResponse> lifestyle(@Query("type") String type, @Query("location") String location);

    //获取必应每日一图
    @GET("/HPImageArchive.aspx?format=js&idx=0&n=1")
    Observable<BingResponse> bing();
    //获取24小时天气信息
    @GET("/v7/weather/24h?key=" + API_KEY)
    Observable<HourlyResponse> hourlyWeather(@Query("location") String location);
    //获取空气质量
    @GET("/v7/air/now?key=" + API_KEY)
    Observable<AirResponse> airWeather(@Query("location") String location);



}

