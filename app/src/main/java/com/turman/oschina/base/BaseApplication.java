package com.turman.oschina.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.turman.oschina.cache.DataCleanManager;
import com.turman.oschina.di.components.AppComponent;
import com.turman.oschina.di.components.DaggerAppComponent;
import com.turman.oschina.di.modules.AppModule;
import com.turman.oschina.utils.AppUtil;
import com.turman.oschina.utils.SharedPreferencesUtil;
import com.turman.oschina.utils.TDevice;
import com.turman.oschina.utils.ToastUtil;

import javax.inject.Inject;

/**
 * Created by dqf on 2016/4/18.
 */
@SuppressLint("InflateParams")
public class BaseApplication extends Application{
    private static String PREF_NAME = "creativelocker.pref";
    private static String LAST_REFRESH_TIME = "last_refresh_time.pref";

    static Context _context;
    static Resources _resource;
    private static String lastToast = "";
    private static long lastToastTime;

    protected AppComponent mAppComponent;

    @Inject
    protected SharedPreferencesUtil mSharedPreferencesUtil;
    @Inject
    protected AppUtil mAppUtil;
    @Inject
    protected ToastUtil mToastUtil;
    @Inject
    protected TDevice mTDevice;
    @Inject
    protected DataCleanManager mDataCleanManager;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mAppComponent.inject(this);
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }

    public SharedPreferencesUtil getSharedPreferencesUtil(){
        return mSharedPreferencesUtil;
    }

    public AppUtil getAppUtil(){
        return mAppUtil;
    }

    public ToastUtil getToastUtil(){
        return mToastUtil;
    }

    public DataCleanManager getDataCleanManager(){
        return mDataCleanManager;
    }

    public TDevice getTDevice(){
        return mTDevice;
    }
}



































