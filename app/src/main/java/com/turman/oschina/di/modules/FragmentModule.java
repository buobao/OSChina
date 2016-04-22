package com.turman.oschina.di.modules;

import android.support.v4.app.Fragment;

import com.turman.oschina.di.annotation.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dqf on 2016/4/21.
 */
@Module
public class FragmentModule {
    Fragment mFragment;

    public FragmentModule(Fragment fragment){
        mFragment = fragment;
    }

    @Provides @FragmentScope
    public Fragment providesActivity(){
        return mFragment;
    }

}
