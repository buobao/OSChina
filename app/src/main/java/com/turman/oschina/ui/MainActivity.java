package com.turman.oschina.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TabHost;

import com.networkbench.agent.impl.NBSAppAgent;
import com.turman.oschina.AppConfig;
import com.turman.oschina.R;
import com.turman.oschina.base.BaseActivity;
import com.turman.oschina.bean.Constants;
import com.turman.oschina.bean.base.Notice;
import com.turman.oschina.interf.BaseViewInterface;
import com.turman.oschina.widget.BadgeView;
import com.turman.oschina.widget.MyFragmentTabHost;

import butterknife.Bind;

/**
 * Created by dqf on 2016/4/21.
 */
public class MainActivity extends BaseActivity implements
        NavigationDrawerFragment.NavigationDrawerCallbacks,TabHost.OnTabChangeListener,
        BaseViewInterface, View.OnClickListener,View.OnTouchListener {
    /**
     * Fragment managing the behaviors, interactions and presentation of the
     * navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Bind(android.R.id.tabhost)
    public MyFragmentTabHost mTabHost;

    private BadgeView mBvNotice;

    public static Notice mNotice;

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Constants.INTENT_ACTION_NOTICE)) {
                mNotice = (Notice) intent.getSerializableExtra("notice_bean");
                int atmeCount = mNotice.atmeCount;// @我
                int msgCount = mNotice.msgCount;// 留言
                int reviewCount = mNotice.reviewCount;// 评论
                int newFansCount = mNotice.newFansCount;// 新粉丝
                int newLikeCount = mNotice.newLikeCount;// 收到赞
                int activeCount = atmeCount + reviewCount + msgCount
                        + newFansCount + newLikeCount;

                Fragment fragment = getCurrentFragment();
//                if (fragment instanceof MyInformationFragment) {
//                    ((MyInformationFragment) fragment).setNotice();
//                } else {
//                    if (activeCount > 0) {
//                        mBvNotice.setText(activeCount + "");
//                        mBvNotice.show();
//                    } else {
//                        mBvNotice.hide();
//                        mNotice = null;
//                    }
//                }
            } else if (intent.getAction()
                    .equals(Constants.INTENT_ACTION_LOGOUT)) {
                mBvNotice.hide();
                mNotice = null;
            }
        }
    };

    /**
     * Used to store the last screen title. For use in
     * {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Bind(R.id.quick_option_iv)
    View mAddBt;

    @Override
    public int getLayout() {
        return R.layout.act_main;
    }

    @Override
    protected void beforeSetContentView() {
        if (mAppContext.getNightModeSwitch()) {
            setTheme(R.style.AppBaseTheme_Night);
        } else {
            setTheme(R.style.AppBaseTheme_Light);
        }
    }

    @Override
    protected void afterSetContentView(View view) {
        handleIntent(getIntent());
        // 注册听云的检测分析
        NBSAppAgent.setLicenseKey("0ed0cc66c5cb45c0a91c6fa932ca99ac")
                .withCrashReportEnabled(true).withLocationServiceEnabled(true)
                .start(this);

        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        if (android.os.Build.VERSION.SDK_INT > 10) {
            mTabHost.getTabWidget().setShowDividers(0);
        }

        initTabs();

        // 中间按键图片触发
        mAddBt.setOnClickListener(this);

        mTabHost.setCurrentTab(0);
        mTabHost.setOnTabChangedListener(this);

        IntentFilter filter = new IntentFilter(Constants.INTENT_ACTION_NOTICE);
        filter.addAction(Constants.INTENT_ACTION_LOGOUT);
        registerReceiver(mReceiver, filter);
        //NoticeUtils.bindToService(this);

        if (mAppContext.isFristStart()) {
            mNavigationDrawerFragment.openDrawerMenu();
            mDataCleanManager.cleanInternalCache();
            mAppContext.setFristStart(false);
        }

        checkUpdate();

    }

    private void initTabs() {
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    private void checkUpdate() {
        if (!mSharedPreferencesUtil.get(AppConfig.KEY_CHECK_UPDATE, true)) {
            return;
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
//                new UpdateManager(MainActivity.this, false).checkUpdate();
            }
        }, 2000);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    /**
     * 处理传进来的intent
     *
     * @author 火蚁 2015-1-28 下午3:48:44
     *
     * @return void
     * @param intent
     */
    private void handleIntent(Intent intent) {
        if (intent == null)
            return;
        String action = intent.getAction();
        if (action != null && action.equals(Intent.ACTION_VIEW)) {
            //UIHelper.showUrlRedirect(this, intent.getDataString());
        } else if (intent.getBooleanExtra("NOTICE", false)) {
            notifitcationBarClick(intent);
        }
    }

    /**
     * 从通知栏点击的时候响应
     *
     * @param fromWhich
     */
    private void notifitcationBarClick(Intent fromWhich) {
        if (fromWhich != null) {
            boolean fromNoticeBar = fromWhich.getBooleanExtra("NOTICE", false);
            if (fromNoticeBar) {
//                Intent toMyInfor = new Intent(this, SimpleBackActivity.class);
//                toMyInfor.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE, SimpleBackPage.MY_MES.getValue());
//                startActivity(toMyInfor);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.search:
                //UIHelper.showSimpleBack(this, SimpleBackPage.SEARCH);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            // 点击了快速操作按钮
            case R.id.quick_option_iv:
                showQuickOption();
                break;
            default:
                break;
        }
    }

    // 显示快速操作界面
    private void showQuickOption() {
//        final QuickOptionDialog dialog = new QuickOptionDialog(
//                MainActivity.this);
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
    }

    @Override
    public void onTabChanged(String tabId) {
        final int size = mTabHost.getTabWidget().getTabCount();
        for (int i = 0; i < size; i++) {
            View v = mTabHost.getTabWidget().getChildAt(i);
            if (i == mTabHost.getCurrentTab()) {
                v.setSelected(true);
            } else {
                v.setSelected(false);
            }
        }
//        if (tabId.equals(getString(MainTab.ME.getResName()))) {
//            mBvNotice.setText("");
//            mBvNotice.hide();
//        }
        supportInvalidateOptionsMenu();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        super.onTouchEvent(event);
        boolean consumed = false;
        // use getTabHost().getCurrentTabView to decide if the current tab is
        // touched again
        if (event.getAction() == MotionEvent.ACTION_DOWN
                && v.equals(mTabHost.getCurrentTabView())) {
            // use getTabHost().getCurrentView() to get a handle to the view
            // which is displayed in the tab - and to get this views context
            Fragment currentFragment = getCurrentFragment();
//            if (currentFragment != null
//                    && currentFragment instanceof OnTabReselectListener) {
//                OnTabReselectListener listener = (OnTabReselectListener) currentFragment;
//                listener.onTabReselect();
//                consumed = true;
//            }
        }
        return consumed;
    }

    private Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentByTag(
                mTabHost.getCurrentTabTag());
    }

    /**
     * 监听返回--是否退出程序
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 是否退出应用
            if (mSharedPreferencesUtil.get(AppConfig.KEY_DOUBLE_CLICK_EXIT, true)) {
                return mDoubleClickExitHelper.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        // 当 API Level > 11 调用这个方法可能导致奔溃（android.os.Build.VERSION.SDK_INT > 11）
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //NoticeUtils.unbindFromService(this);
        unregisterReceiver(mReceiver);
        mReceiver = null;
        //NoticeUtils.tryToShutDown(this);
    }

}
