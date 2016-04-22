package com.turman.oschina.di.components;

import android.content.Context;

import com.turman.oschina.base.BaseDialog;
import com.turman.oschina.di.annotation.ViewScope;
import com.turman.oschina.di.modules.ViewModule;
import com.turman.oschina.utils.TDevice;

import dagger.Component;

/**
 * Created by dqf on 2016/4/22.
 */
@Component(modules = {ViewModule.class})
@ViewScope
public interface ViewComponent {
    void inject(BaseDialog dialog);

    Context getContext();
    TDevice getTDevice();
}
