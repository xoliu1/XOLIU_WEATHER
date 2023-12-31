package com.example.library.base;

import androidx.viewbinding.ViewBinding;

/**
 * 这是一个网络请求类，继承自BaseVBActivity，里面有两个抽象方法，onCreate()自然不用多说了，
 * 而onObserveData()就是在使用LiveData的时候有一个观察数据返回的地方，
 * 为此我写了一个抽象方法，这属于MVVM框架的一部分，但并不是那么严格，
 * 在这个类中我们实现了BaseVBActivity类的initData()抽象方法，那么如果有一个类继承自NetworkActivity，
 * 就不需要重复实现了，只需要实现onCreate()和onObserveData()即可。
 */
public abstract class NetworkActivity<VB extends ViewBinding> extends BaseVBActivity<VB> {

    @Override
    public void initData() {
        onCreate();
        onObserveData();
    }

    protected abstract void onCreate();

    protected abstract void onObserveData();
}

