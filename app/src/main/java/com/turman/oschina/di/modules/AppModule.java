package com.turman.oschina.di.modules;

import android.app.Application;
import android.content.Context;

import com.turman.oschina.base.BaseAppliation;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dqf on 2016/4/18.
 */
@Module
public class AppModule {
    BaseAppliation mApplication;
    Context mContext;

    public AppModule(BaseAppliation appliation) {
        mApplication = appliation;
        mContext = (Context) appliation;
    }

    @Provides @Singleton
    public Application providesApplication(){
        return mApplication;
    }

    @Provides @Singleton
    public Context providesContext(){
        return mContext;
    }
}
