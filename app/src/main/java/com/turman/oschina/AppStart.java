package com.turman.oschina;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.turman.oschina.base.BaseApplication;
import com.turman.oschina.di.components.ActivityComponent;
import com.turman.oschina.di.modules.ActivityModule;
import com.turman.oschina.ui.MainActivity;
import com.turman.oschina.utils.TDevice;
import com.turman.oschina.utils.ToastUtil;
import com.turman.oschina.utils.net.service.OSChinaService;

import org.kymjs.kjframe.http.KJAsyncTask;
import org.kymjs.kjframe.utils.FileUtils;
import org.kymjs.kjframe.utils.PreferenceHelper;

import java.io.File;

import javax.inject.Inject;

/**
 * Created by dqf on 2016/4/18.
 */
public class AppStart extends Activity {
    ActivityComponent mActivityComponent;
    @Inject
    ToastUtil mToastUtil;
    @Inject
    OSChinaService mService;
    @Inject
    AppManager mAppManager;
    @Inject
    TDevice mTDevice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = ((BaseApplication)getApplication()).getAppComponent().plus(new ActivityModule(this));
        mActivityComponent.inject(this);

        // 防止第三方跳转时出现双实例
        Activity aty = mAppManager.getActivity(MainActivity.class);
        if (aty != null && !aty.isFinishing()) {
            finish();
        }

        final View view = View.inflate(this, R.layout.act_start, null);
        setContentView(view);

        // 渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.5f, 1.0f);
        aa.setDuration(800);
        view.startAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {
                redirectTo();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationStart(Animation animation) {}
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        int cacheVersion = PreferenceHelper.readInt(this, "first_install",
                "first_install", -1);
        int currentVersion = mTDevice.getVersionCode();
        if (cacheVersion < currentVersion) {
            PreferenceHelper.write(this, "first_install", "first_install",
                    currentVersion);
            cleanImageCache();
        }
    }

    private void cleanImageCache() {
        final File folder = FileUtils.getSaveFolder("OSChina/imagecache");
        KJAsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                for (File file : folder.listFiles()) {
                    file.delete();
                }
            }
        });
    }

    /**
     * 跳转到...
     */
    private void redirectTo() {
        Intent uploadLog = new Intent(this, LogUploadService.class);
        startService(uploadLog);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}





























