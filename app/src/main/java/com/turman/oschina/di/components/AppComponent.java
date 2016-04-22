package com.turman.oschina.di.components;

import android.content.Context;

import com.turman.oschina.AppManager;
import com.turman.oschina.base.BaseApplication;
import com.turman.oschina.cache.CacheManager;
import com.turman.oschina.cache.DataCleanManager;
import com.turman.oschina.cache.DiskLruCacheUtil;
import com.turman.oschina.di.modules.ActivityModule;
import com.turman.oschina.di.modules.AppModule;
import com.turman.oschina.di.modules.NetModule;
import com.turman.oschina.utils.AppUtil;
import com.turman.oschina.utils.SharedPreferencesUtil;
import com.turman.oschina.utils.TDevice;
import com.turman.oschina.utils.ToastUtil;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dqf on 2016/4/18.
 */
@Component(modules = {AppModule.class, NetModule.class})
@Singleton
public interface AppComponent {
    void inject(BaseApplication appliation);

    //这里声明注入一个Context,下面的自定义的注入工具类构造函数中都有该参数。
    Context getContext();
    SharedPreferencesUtil getSharedPreferencesUtil();
    AppUtil getAppUtil();

    ToastUtil getToastUtil();
    TDevice getTDevice();
    DiskLruCacheUtil getDiskLruCacheUtil();
    CacheManager getCacheManager();
    DataCleanManager getDataCleanManager();
    AppManager getAppManager();

    ActivityComponent plus(ActivityModule activityModule);
}
