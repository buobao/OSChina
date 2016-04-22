package com.turman.oschina.di.modules;

import android.content.Context;

import com.turman.oschina.di.annotation.ViewScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dqf on 2016/4/22.
 */
@Module
public class ViewModule {
    private Context mContext;

    public ViewModule(Context context){
        mContext = context;
    }
    @Provides @ViewScope
    public Context providesContext(){
        return mContext;
    }
}
