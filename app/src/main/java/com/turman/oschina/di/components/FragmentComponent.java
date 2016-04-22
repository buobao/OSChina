package com.turman.oschina.di.components;

import android.support.v4.app.Fragment;

import com.turman.oschina.base.BaseFragment;
import com.turman.oschina.di.annotation.FragmentScope;
import com.turman.oschina.di.modules.FragmentModule;

import dagger.Subcomponent;

/**
 * Created by dqf on 2016/4/21.
 */
@Subcomponent(modules = {FragmentModule.class})
@FragmentScope
public interface FragmentComponent {
    void inject(BaseFragment fragment);

    Fragment getFragment();
}
