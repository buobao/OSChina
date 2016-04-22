package com.turman.oschina.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;

import com.turman.oschina.AppManager;
import com.turman.oschina.R;

import javax.inject.Inject;

/***
 * 双击退出
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2015年1月5日 下午7:07:44
 *
 */
public class DoubleClickExitHelper {

    private final Activity mActivity;
    private final AppManager mAppManager;

    private boolean isOnKeyBacking;
    private Handler mHandler;
    private Toast mBackToast;

    @Inject
    public DoubleClickExitHelper(Activity activity, AppManager appManager) {
        mActivity = activity;
        mAppManager = appManager;
        mHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * Activity onKeyDown事件
     * */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode != KeyEvent.KEYCODE_BACK) {
            return false;
        }
        if(isOnKeyBacking) {
            mHandler.removeCallbacks(onBackTimeRunnable);
            if(mBackToast != null){
                mBackToast.cancel();
            }
            // 退出
            mAppManager.AppExit(mActivity);
            return true;
        } else {
            isOnKeyBacking = true;
            if(mBackToast == null) {
                mBackToast = Toast.makeText(mActivity, R.string.tip_double_click_exit, 2000);
            }
            mBackToast.show();
            mHandler.postDelayed(onBackTimeRunnable, 2000);
            return true;
        }
    }

    private Runnable onBackTimeRunnable = new Runnable() {

        @Override
        public void run() {
            isOnKeyBacking = false;
            if(mBackToast != null){
                mBackToast.cancel();
            }
        }
    };
}