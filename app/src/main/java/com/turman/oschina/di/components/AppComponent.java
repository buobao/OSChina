package com.turman.oschina.di.components;

import android.content.Context;

import com.turman.oschina.base.BaseAppliation;
import com.turman.oschina.di.modules.ActivityModule;
import com.turman.oschina.di.modules.AppModule;
import com.turman.oschina.di.modules.NetModule;
import com.turman.oschina.utils.AppUtil;
import com.turman.oschina.utils.SharedPreferencesUtil;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dqf on 2016/4/18.
 */
@Component(modules = {AppModule.class, NetModule.class})
@Singleton
public interface AppComponent {
    void inject(BaseAppliation appliation);

    //这里声明注入一个Context,一面的2个自定义的注入工具类构造函数中都有该参数。
    Context getContext();
    SharedPreferencesUtil getSharedPreferencesUtil();
//    ToastUtil getToastUtil();
    AppUtil getAppUtil();

    ActivityComponent plus(ActivityModule activityModule);
}
