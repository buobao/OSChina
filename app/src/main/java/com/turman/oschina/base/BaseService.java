package com.turman.oschina.base;

import android.app.Service;

import com.turman.oschina.di.components.DaggerServiceComponent;
import com.turman.oschina.di.components.ServiceComponent;
import com.turman.oschina.utils.net.service.OSChinaService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by dqf on 2016/4/21.
 */
public abstract class BaseService extends Service {

    protected ServiceComponent mServiceCompat;
    @Inject
    protected OSChinaService mOSChinaService;

    private List<Subscription> mSubscriptions = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        mServiceCompat = DaggerServiceComponent.builder().build();
        mServiceCompat.inject(this);
    }

    public void addTask(Subscription subscription){
        mSubscriptions.add(subscription);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mSubscriptions.size() > 0) {
            for (Subscription s:mSubscriptions){
                if (s != null && !s.isUnsubscribed()){
                    s.unsubscribe();
                }
            }
        }
    }
}
