package com.turman.oschina.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.DisplayMetrics;

import javax.inject.Inject;

/**
 * Created by dqf on 2016/4/18.
 */
public class SharedPreferencesUtil {
    private static String PREF_NAME = "creativelocker.pref";
    private static String LAST_REFRESH_TIME = "last_refresh_time.pref";

    private SharedPreferences mPreferences;
    private SharedPreferences mPreferencesTime;
    private Context mContext;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences.Editor mEditorTime;
    private boolean sIsAtLeastGB;

    @Inject
    public SharedPreferencesUtil(Context context){
        mContext = context;
        mPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_MULTI_PROCESS);
        mEditor  = mPreferences.edit();

        mPreferencesTime = context.getSharedPreferences(LAST_REFRESH_TIME, Context.MODE_MULTI_PROCESS);
        mEditorTime = mPreferencesTime.edit();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            sIsAtLeastGB = true;
        }
    }

    public void apply(SharedPreferences.Editor editor){
        if (sIsAtLeastGB) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public SharedPreferences getPreferences(String... name){
        if (name == null) {
            return null;
        }

        if (name.length == 0) {
            return mPreferences;
        }

        return mContext.getSharedPreferences(name[0],Context.MODE_MULTI_PROCESS);
    }

    public float get(String key, float defValue) {
        return getPreferences().getFloat(key,defValue);
    }
    public long get(String key, long defValue) {
        return getPreferences().getLong(key,defValue);
    }
    public int get(String key, int defValue) {
        return getPreferences().getInt(key,defValue);
    }
    public String get(String key, String defValue) {
        return getPreferences().getString(key,defValue);
    }
    public boolean get(String key, boolean defValue) {
        return getPreferences().getBoolean(key,defValue);
    }

    public void set(String key, int value){
        mEditor.putInt(key, value);
        apply(mEditor);
    }
    public void set(String key, String value){
        mEditor.putString(key, value);
        apply(mEditor);
    }
    public void set(String key, float value){
        mEditor.putFloat(key, value);
        apply(mEditor);
    }
    public void set(String key, long value){
        mEditor.putLong(key, value);
        apply(mEditor);
    }
    public void set(String key, boolean value) {
        mEditor.putBoolean(key, value);
        apply(mEditor);
    }



    /**
     * 获取列表的上次刷新时间
     * @param key
     * @return
     */
    public String getLastRefreshTime(String key) {
        return mPreferencesTime.getString(key, StringUtils.getCurTimeStr());
    }

    /**
     * 记录列表上次刷新时间
     * @param key
     * @param value
     */
    public void putToLastRefreshTime(String key, String value) {
        mEditorTime.putString(key, value);
        apply(mEditorTime);
    }


    /**
     * 放入已读文章列表中
     *
     */
    public void putReadedPostList(String prefFileName, String key,String value) {
        SharedPreferences preferences = getPreferences(prefFileName);
        int size = preferences.getAll().size();
        SharedPreferences.Editor editor = preferences.edit();
        if (size >= 100) {
            editor.clear();
        }
        editor.putString(key, value);
        apply(editor);
    }

    /**
     * 读取是否是已读的文章列表
     *
     * @return
     */
    public boolean isOnReadedPostList(String prefFileName, String key) {
        return getPreferences(prefFileName).contains(key);
    }

    public int[] getDisplaySize() {
        return new int[]{mPreferences.getInt("screen_width", 480), mPreferences.getInt("screen_height", 854)};
    }

    public void saveDisplaySize(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mEditor.putInt("screen_width", displaymetrics.widthPixels);
        mEditor.putInt("screen_height", displaymetrics.heightPixels);
        mEditor.putFloat("density", displaymetrics.density);
        mEditor.commit();
    }

}























