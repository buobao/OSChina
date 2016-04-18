package com.turman.oschina.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.turman.oschina.di.components.AppComponent;
import com.turman.oschina.di.components.DaggerAppComponent;
import com.turman.oschina.di.modules.AppModule;
import com.turman.oschina.utils.AppUtil;
import com.turman.oschina.utils.SharedPreferencesUtil;

import javax.inject.Inject;

/**
 * Created by dqf on 2016/4/18.
 */
@SuppressLint("InflateParams")
public class BaseAppliation extends Application{
    private static String PREF_NAME = "creativelocker.pref";
    private static String LAST_REFRESH_TIME = "last_refresh_time.pref";

    static Context _context;
    static Resources _resource;
    private static String lastToast = "";
    private static long lastToastTime;

    AppComponent mAppComponent;

    @Inject
    SharedPreferencesUtil mSharedPreferencesUtil;
    @Inject
    AppUtil mAppUtil;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mAppComponent.inject(this);
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }
}



































