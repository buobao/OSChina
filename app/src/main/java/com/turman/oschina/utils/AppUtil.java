package com.turman.oschina.utils;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Inject;

/**
 * Created by dqf on 2016/4/18.
 */
public class AppUtil {
    private Context mContext;

    private Resources mResources;

    @Inject
    public AppUtil(Context context){
        mContext = context;
        mResources = mContext.getResources();
    }

    public String string(int id) {
        return mResources.getString(id);
    }

    public String string(int id, Object... args) {
        return mResources.getString(id, args);
    }

}
