package com.turman.oschina.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.turman.oschina.AppContext;
import com.turman.oschina.AppManager;
import com.turman.oschina.cache.DataCleanManager;
import com.turman.oschina.di.components.ActivityComponent;
import com.turman.oschina.di.modules.ActivityModule;
import com.turman.oschina.utils.DoubleClickExitHelper;
import com.turman.oschina.utils.SharedPreferencesUtil;
import com.turman.oschina.utils.ToastUtil;
import com.turman.oschina.utils.net.service.OSChinaService;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by dqf on 2016/4/18.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected ActivityComponent mActivityComponent;
    protected AppContext mAppContext;

    @Inject
    protected ToastUtil mToastUtil;
    @Inject
    protected OSChinaService mService;
    @Inject
    protected AppManager mAppManager;
    @Inject
    protected DoubleClickExitHelper mDoubleClickExitHelper;
    @Inject
    protected DataCleanManager mDataCleanManager;
    @Inject
    protected SharedPreferencesUtil mSharedPreferencesUtil;
//    @Inject
//    protected AppContext mAppContext;   //注入报错，这里不能在activity中注入上下文

    public ActivityComponent getActivityComponent(){
        return mActivityComponent;
    }

    public ToastUtil getToastUtil() {
        return mToastUtil;
    }

    public AppManager getAppManager() {
        return mAppManager;
    }

    public OSChinaService getOSChinaService(){
        return mService;
    }

    public abstract int getLayout();

    protected abstract void beforeSetContentView();

    protected abstract void afterSetContentView(View view);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = ((BaseApplication)getApplication()).getAppComponent().plus(new ActivityModule(this));
        mActivityComponent.inject(this);
        mAppContext = (AppContext) getApplication();

        beforeSetContentView();
        View view = getLayoutInflater().inflate(getLayout(),null);
        setContentView(view);

        mAppManager.addActivity(this);
        ButterKnife.bind(this,view);

        afterSetContentView(view);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public AppContext getAppContext() {
        return mAppContext;
    }
}