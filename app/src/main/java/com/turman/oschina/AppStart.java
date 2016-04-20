package com.turman.oschina;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.turman.oschina.base.BaseAppliation;
import com.turman.oschina.di.components.ActivityComponent;
import com.turman.oschina.utils.SharedPreferencesUtil;
import com.turman.oschina.utils.ToastUtil;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dqf on 2016/4/18.
 */
public class AppStart extends Activity {
    @Bind(R.id.show_txt)
    protected TextView mTextView;
    @Bind(R.id.show_btn)
    protected Button mTextBtn;

    @Inject
    SharedPreferencesUtil mSharedPreferencesUtil;

    ActivityComponent mActivityComponent;
    @Inject
    ToastUtil mToastUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_start);
        ButterKnife.bind(this);

        //mActivityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).build();
//        mActivityComponent = ((BaseAppliation)getApplication()).getAppComponent().plus(new ActivityModule(this));
//        mActivityComponent.inject(this);


        mSharedPreferencesUtil = ((BaseAppliation)getApplication()).getAppComponent().getSharedPreferencesUtil();
        mSharedPreferencesUtil.set("userName","buobao");
    }

    @OnClick({R.id.show_btn})
    protected void buttonClick(View v){
        switch (v.getId()){
            case R.id.show_btn:
                mToastUtil.showToast("This messga from Toast!");
                mTextView.setText(mSharedPreferencesUtil.get("userName","default"));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}





























