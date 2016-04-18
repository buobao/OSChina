package com.turman.oschina.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.turman.oschina.R;

import javax.inject.Inject;

/**
 * Created by dqf on 2016/4/18.
 */
public class ToastUtil {
    private Context mContext;

    private String lastToast = "";
    private long lastToastTime;

    @Inject
    public ToastUtil(Activity activity){
        mContext = activity;
    }

    public void showToast(int message) {
        showToast(message, Toast.LENGTH_LONG, 0);
    }

    public void showToast(String message) {
        showToast(message, Toast.LENGTH_LONG, 0, Gravity.BOTTOM);
    }

    public void showToast(int message, int icon) {
        showToast(message, Toast.LENGTH_LONG, icon);
    }

    public void showToast(String message, int icon) {
        showToast(message, Toast.LENGTH_LONG, icon, Gravity.BOTTOM);
    }

    public void showToastShort(int message) {
        showToast(message, Toast.LENGTH_SHORT, 0);
    }

    public void showToastShort(String message) {
        showToast(message, Toast.LENGTH_SHORT, 0, Gravity.BOTTOM);
    }

    public void showToastShort(int message, Object... args) {
        showToast(message, Toast.LENGTH_SHORT, 0, Gravity.BOTTOM, args);
    }

    public void showToast(int message, int duration, int icon) {
        showToast(message, duration, icon, Gravity.BOTTOM);
    }

    public void showToast(int message, int duration, int icon,
                                 int gravity) {
        showToast(mContext.getString(message), duration, icon, gravity);
    }

    public void showToast(int message, int duration, int icon,
                                 int gravity, Object... args) {
        showToast(mContext.getString(message, args), duration, icon, gravity);
    }

    public void showToast(String message, int duration, int icon,
                                 int gravity) {
        if (message != null && !message.equalsIgnoreCase("")) {
            long time = System.currentTimeMillis();
            if (!message.equalsIgnoreCase(lastToast)
                    || Math.abs(time - lastToastTime) > 2000) {
                View view = LayoutInflater.from(mContext).inflate(
                        R.layout.view_toast, null);
                ((TextView) view.findViewById(R.id.title_tv)).setText(message);
                if (icon != 0) {
                    ((ImageView) view.findViewById(R.id.icon_iv))
                            .setImageResource(icon);
                    ((ImageView) view.findViewById(R.id.icon_iv))
                            .setVisibility(View.VISIBLE);
                }
                Toast toast = new Toast(mContext);
                toast.setView(view);
                if (gravity == Gravity.CENTER) {
                    toast.setGravity(gravity, 0, 0);
                } else {
                    toast.setGravity(gravity, 0, 35);
                }

                toast.setDuration(duration);
                toast.show();
                lastToast = message;
                lastToastTime = System.currentTimeMillis();
            }
        }
    }

}
