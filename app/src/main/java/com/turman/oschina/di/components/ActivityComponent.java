package com.turman.oschina.di.components;

import android.app.Activity;

import com.turman.oschina.AppStart;
import com.turman.oschina.di.annotation.ActivityScope;
import com.turman.oschina.di.modules.ActivityModule;
import com.turman.oschina.utils.ToastUtil;

import dagger.Subcomponent;

/**
 * Created by dqf on 2016/4/18.
 */
@Subcomponent(modules = {ActivityModule.class})
@ActivityScope
public interface ActivityComponent {
    void inject(AppStart activity);

    Activity getActivity();
    ToastUtil getToastUtil();

}
