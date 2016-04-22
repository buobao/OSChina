package com.turman.oschina.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.turman.oschina.AppManager;
import com.turman.oschina.di.components.ActivityComponent;
import com.turman.oschina.di.modules.ActivityModule;
import com.turman.oschina.utils.ToastUtil;
import com.turman.oschina.utils.net.service.OSChinaService;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by dqf on 2016/4/18.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected ActivityComponent mActivityComponent;

    @Inject
    protected ToastUtil mToastUtil;
    @Inject
    protected OSChinaService mService;
    @Inject
    protected AppManager mAppManager;
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

    protected abstract void afterSetContentView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContentView();
        View view = getLayoutInflater().inflate(getLayout(),null);
        setContentView(view);

        mActivityComponent = ((BaseApplication)getApplication()).getAppComponent().plus(new ActivityModule(this));
        mActivityComponent.inject(this);

        mAppManager.addActivity(this);
        ButterKnife.bind(this,view);

        afterSetContentView();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}