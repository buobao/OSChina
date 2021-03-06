package com.turman.oschina.di.components;

import android.app.Activity;

import com.turman.oschina.AppStart;
import com.turman.oschina.base.BaseActivity;
import com.turman.oschina.di.annotation.ActivityScope;
import com.turman.oschina.di.modules.ActivityModule;
import com.turman.oschina.di.modules.FragmentModule;
import com.turman.oschina.utils.DoubleClickExitHelper;
import com.turman.oschina.utils.UIHelper;

import dagger.Subcomponent;

/**
 * Created by dqf on 2016/4/18.
 */
@Subcomponent(modules = {ActivityModule.class})
@ActivityScope
public interface ActivityComponent {
    void inject(BaseActivity activity);
    void inject(AppStart appStart);

    Activity getActivity();
    UIHelper getUIHelper();
    DoubleClickExitHelper getDoubleClickExitHelper();   //这个需要写到MainComponent中

    FragmentComponent plus(FragmentModule fragmentModule);
}
