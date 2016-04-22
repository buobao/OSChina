package com.turman.oschina.ui;

import android.app.Activity;
import android.os.Bundle;

import com.turman.oschina.R;

/**
 * Created by dqf on 2016/4/21.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
    }

    //    @Override
//    public int getLayout() {
//        return R.layout.act_main;
//    }
//
//    @Override
//    protected void beforeSetContentView() {
//        if (mAppContext.getNightModeSwitch()) {
//            setTheme(R.style.AppBaseTheme_Night);
//        } else {
//            setTheme(R.style.AppBaseTheme_Light);
//        }
//    }
//
//    @Override
//    protected void afterSetContentView() {
//        initView();
//
////        handleIntent(getIntent());
////        // 注册听云的检测分析
////        NBSAppAgent.setLicenseKey("0ed0cc66c5cb45c0a91c6fa932ca99ac")
////                .withCrashReportEnabled(true).withLocationServiceEnabled(true)
////                .start(this);
//    }
//
//    private void initView() {
//
//    }
}
