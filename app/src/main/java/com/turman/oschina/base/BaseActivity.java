package com.turman.oschina.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.turman.oschina.di.components.ActivityComponent;
import com.turman.oschina.di.modules.ActivityModule;

import butterknife.ButterKnife;

/**
 * Created by dqf on 2016/4/18.
 */
public class BaseActivity extends AppCompatActivity {
    protected ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = ((BaseAppliation)getApplication()).getAppComponent().plus(new ActivityModule(this));
        mActivityComponent.inject(this);

        ButterKnife.bind(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
