package com.turman.oschina;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.turman.oschina.base.BaseAppliation;
import com.turman.oschina.bean.list.NewsList;
import com.turman.oschina.di.components.ActivityComponent;
import com.turman.oschina.di.modules.ActivityModule;
import com.turman.oschina.utils.SharedPreferencesUtil;
import com.turman.oschina.utils.ToastUtil;
import com.turman.oschina.utils.net.service.OSChinaService;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
    @Inject
    OSChinaService mService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_start);
        ButterKnife.bind(this);

        //mActivityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).build();
        mActivityComponent = ((BaseAppliation)getApplication()).getAppComponent().plus(new ActivityModule(this));
        mActivityComponent.inject(this);


//        mSharedPreferencesUtil = ((BaseAppliation)getApplication()).getAppComponent().getSharedPreferencesUtil();
        mSharedPreferencesUtil.set("userName","buobao");

        Map<String, Integer> params = new HashMap<>();
        params.put("catalog",1);
        params.put("pageIndex",1);
        params.put("pageSize",20);
        Observable.just(params)
                .flatMap(new Func1<Map<String, Integer>, Observable<NewsList>>() {
                    @Override
                    public Observable<NewsList> call(Map<String, Integer> stringIntegerMap) {
                        Observable<NewsList> r = mService.getNewsList(stringIntegerMap.get("catalog"),stringIntegerMap.get("pageIndex"),stringIntegerMap.get("pageSize"));
                        return r;
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsList>() {
                    @Override
                    public void call(NewsList resultBean) {
                        NewsList r = resultBean;
                    }
                });
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





























