package com.turman.oschina;

import com.turman.oschina.base.BaseAppliation;

/**
 * Created by dqf on 2016/4/20.
 */
public class AppContext extends BaseAppliation {

    public static final int PAGE_SIZE = 20;// 默认分页大小

    private static AppContext instance;

    private int loginUid;

    private boolean login;

    @Override
    public void onCreate() {
        super.onCreate();

        init();
        initLogin();
    }

    private void initLogin() {

    }

    private void init() {

    }
}















































