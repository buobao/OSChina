package com.turman.oschina;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.turman.oschina.base.BaseApplication;
import com.turman.oschina.bean.Constants;
import com.turman.oschina.bean.User;
import com.turman.oschina.utils.CyptoUtils;
import com.turman.oschina.utils.MethodsCompat;
import com.turman.oschina.utils.StringUtils;
import com.turman.oschina.utils.TLog;

import org.kymjs.kjframe.Core;
import org.kymjs.kjframe.http.HttpConfig;
import org.kymjs.kjframe.utils.KJLoger;

import java.util.Properties;
import java.util.UUID;

import static com.turman.oschina.AppConfig.KEY_FRITST_START;
import static com.turman.oschina.AppConfig.KEY_LOAD_IMAGE;
import static com.turman.oschina.AppConfig.KEY_NIGHT_MODE_SWITCH;
import static com.turman.oschina.AppConfig.KEY_TWEET_DRAFT;

/**
 * Created by dqf on 2016/4/20.
 */
public class AppContext extends BaseApplication {
    public static final int PAGE_SIZE = 20;// 默认分页大小

    private int loginUid;
    private boolean login;

    @Override
    public void onCreate() {
        super.onCreate();

        init();
        initLogin();
    }

    private void initLogin() {
        User user = getLoginUser();
        if (null != user && user.uid > 0) {
            login = true;
            loginUid = user.uid;
        } else {
            this.cleanLoginInfo();
        }
    }

    private void init() {
        // Log控制器
        KJLoger.openDebutLog(true);
        TLog.DEBUG = BuildConfig.DEBUG;

        // Bitmap缓存地址
        HttpConfig.CACHEPATH = "OSChina/imagecache";
    }

    public boolean containsProperty(String key) {
        Properties props = getProperties();
        return props.containsKey(key);
    }

    public void setProperties(Properties ps) {
        AppConfig.getAppConfig(this).set(ps);
    }

    public Properties getProperties() {
        return AppConfig.getAppConfig(this).get();
    }

    public void setProperty(String key, String value) {
        AppConfig.getAppConfig(this).set(key, value);
    }

    /**
     * 获取cookie时传AppConfig.CONF_COOKIE
     *
     * @param key
     * @return
     */
    public String getProperty(String key) {
        String res = AppConfig.getAppConfig(this).get(key);
        return res;
    }

    public void removeProperty(String... key) {
        AppConfig.getAppConfig(this).remove(key);
    }

    /**
     * 获取App唯一标识
     *
     * @return
     */
    public String getAppId() {
        String uniqueID = getProperty(AppConfig.CONF_APP_UNIQUEID);
        if (StringUtils.isEmpty(uniqueID)) {
            uniqueID = UUID.randomUUID().toString();
            setProperty(AppConfig.CONF_APP_UNIQUEID, uniqueID);
        }
        return uniqueID;
    }

    /**
     * 获取App安装包信息
     *
     * @return
     */
    public PackageInfo getPackageInfo() {
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        if (info == null)
            info = new PackageInfo();
        return info;
    }

    /**
     * 保存登录信息
     *
     * @param user 用户信息
     */
    @SuppressWarnings("serial")
    public void saveUserInfo(final User user) {
        this.loginUid = user.uid;
        this.login = true;
        setProperties(new Properties() {
            {
                setProperty("user.uid", String.valueOf(user.uid));
                setProperty("user.name", user.name);
                setProperty("user.face", user.portrait);// 用户头像-文件名
                setProperty("user.account", user.account);
                setProperty("user.pwd",
                        CyptoUtils.encode("oschinaApp", user.pwd));
                setProperty("user.location", user.location);
                setProperty("user.followers",
                        String.valueOf(user.followers));
                setProperty("user.fans", String.valueOf(user.fans));
                setProperty("user.score", String.valueOf(user.score));
                setProperty("user.favoritecount",
                        String.valueOf(user.favoritecount));
                setProperty("user.gender", String.valueOf(user.gender));
                setProperty("user.isRememberMe",
                        String.valueOf(user.isRememberMe));// 是否记住我的信息
            }
        });
    }

    /**
     * 更新用户信息
     *
     * @param user
     */
    @SuppressWarnings("serial")
    public void updateUserInfo(final User user) {
        setProperties(new Properties() {
            {
                setProperty("user.name", user.name);
                setProperty("user.face", user.portrait);// 用户头像-文件名
                setProperty("user.followers",
                        String.valueOf(user.followers));
                setProperty("user.fans", String.valueOf(user.fans));
                setProperty("user.score", String.valueOf(user.score));
                setProperty("user.favoritecount",
                        String.valueOf(user.favoritecount));
                setProperty("user.gender", String.valueOf(user.gender));
            }
        });
    }

    /**
     * 获得登录用户的信息
     *
     * @return
     */
    public User getLoginUser() {
        User user = new User();
        user.uid = StringUtils.toInt(getProperty("user.uid"), 0);
        user.name = getProperty("user.name");
        user.portrait = getProperty("user.face");
        user.account = getProperty("user.account");
        user.location = getProperty("user.location");
        user.followers = StringUtils.toInt(getProperty("user.followers"), 0);
        user.fans = StringUtils.toInt(getProperty("user.fans"), 0);
        user.score = StringUtils.toInt(getProperty("user.score"), 0);
        user.favoritecount = StringUtils.toInt(getProperty("user.favoritecount"), 0);
        user.isRememberMe = StringUtils.toBool(getProperty("user.isRememberMe"));
        user.gender = getProperty("user.gender");
        return user;
    }

    /**
     * 清除登录信息
     */
    public void cleanLoginInfo() {
        this.loginUid = 0;
        this.login = false;
        removeProperty("user.uid", "user.name", "user.face", "user.location",
                "user.followers", "user.fans", "user.score",
                "user.isRememberMe", "user.gender", "user.favoritecount");
    }

    public int getLoginUid() {
        return loginUid;
    }

    public boolean isLogin() {
        return login;
    }

    /**
     * 用户注销
     */
    public void Logout() {
        cleanLoginInfo();
//        ApiHttpClient.cleanCookie();
        this.cleanCookie();
        this.login = false;
        this.loginUid = 0;

        Intent intent = new Intent(Constants.INTENT_ACTION_LOGOUT);
        sendBroadcast(intent);
    }

    /**
     * 清除保存的缓存
     */
    public void cleanCookie() {
        removeProperty(AppConfig.CONF_COOKIE);
    }

    /**
     * 清除app缓存
     */
    public void clearAppCache() {
        mDataCleanManager.cleanDatabases();
        // 清除数据缓存
        mDataCleanManager.cleanInternalCache();
        // 2.2版本才有将应用缓存转移到sd卡的功能
        if (isMethodsCompat(android.os.Build.VERSION_CODES.FROYO)) {
            mDataCleanManager.cleanCustomCache(MethodsCompat.getExternalCacheDir(this));
        }
        // 清除编辑器保存的临时内容
        Properties props = getProperties();
        for (Object key : props.keySet()) {
            String _key = key.toString();
            if (_key.startsWith("temp"))
                removeProperty(_key);
        }
        Core.getKJBitmap().cleanCache();
    }

    public void setLoadImage(boolean flag) {
        mSharedPreferencesUtil.set(KEY_LOAD_IMAGE, flag);
    }

    /**
     * 判断当前版本是否兼容目标版本的方法
     *
     * @param VersionCode
     * @return
     */
    public boolean isMethodsCompat(int VersionCode) {
        int currentVersion = android.os.Build.VERSION.SDK_INT;
        return currentVersion >= VersionCode;
    }

    public String getTweetDraft() {
        return  mSharedPreferencesUtil.getPreferences().getString(
                KEY_TWEET_DRAFT + getLoginUid(), "");
    }

    public void setTweetDraft(String draft) {
        mSharedPreferencesUtil.set(KEY_TWEET_DRAFT + getLoginUid(), draft);
    }

    public String getNoteDraft() {
        return mSharedPreferencesUtil.getPreferences().getString(
                AppConfig.KEY_NOTE_DRAFT + getLoginUid(), "");
    }

    public void setNoteDraft(String draft) {
        mSharedPreferencesUtil.set(AppConfig.KEY_NOTE_DRAFT + getLoginUid(), draft);
    }

    public boolean isFristStart() {
        return  mSharedPreferencesUtil.getPreferences().getBoolean(KEY_FRITST_START, true);
    }

    public void setFristStart(boolean frist) {
        mSharedPreferencesUtil.set(KEY_FRITST_START, frist);
    }

    //夜间模式
    public boolean getNightModeSwitch() {
        return mSharedPreferencesUtil.getPreferences().getBoolean(KEY_NIGHT_MODE_SWITCH, false);
    }

    // 设置夜间模式
    public void setNightModeSwitch(boolean on) {
        mSharedPreferencesUtil.set(KEY_NIGHT_MODE_SWITCH, on);
    }
}















































