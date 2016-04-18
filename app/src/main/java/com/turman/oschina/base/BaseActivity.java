package com.turman.oschina.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.turman.oschina.di.components.ActivityComponent;

/**
 * Created by dqf on 2016/4/18.
 */
public class BaseActivity extends AppCompatActivity {

    protected ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
