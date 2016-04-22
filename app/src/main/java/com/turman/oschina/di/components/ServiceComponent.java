package com.turman.oschina.di.components;

import com.turman.oschina.base.BaseService;
import com.turman.oschina.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dqf on 2016/4/21.
 */
@Component(modules = NetModule.class)
@Singleton
public interface ServiceComponent {
    void inject(BaseService service);
}
