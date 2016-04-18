package com.turman.oschina.di.modules;

import android.app.Activity;

import com.turman.oschina.di.annotation.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dqf on 2016/4/18.
 */
@Module
public class ActivityModule {
    Activity mActivity;

    public ActivityModule(Activity activity){
        mActivity = activity;
    }

    @Provides @ActivityScope
    public Activity providesActivity(){
        return mActivity;
    }

}
