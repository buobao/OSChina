package com.turman.oschina.base;

import android.app.Dialog;
import android.content.Context;

import com.turman.oschina.di.components.DaggerViewComponent;
import com.turman.oschina.di.components.ViewComponent;
import com.turman.oschina.di.modules.ViewModule;

/**
 * Created by dqf on 2016/4/22.
 */
public class BaseDialog extends Dialog {
    private ViewComponent mViewComponent;

    public ViewComponent getViewComponent() {
        return mViewComponent;
    }

    public BaseDialog(Context context) {
        super(context);
        initComponent(context);
    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
        initComponent(context);
    }

    protected BaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initComponent(context);
    }

    private void initComponent(Context context) {
        mViewComponent = DaggerViewComponent.builder().viewModule(new ViewModule(context)).build();
        mViewComponent.inject(this);
    }
}
