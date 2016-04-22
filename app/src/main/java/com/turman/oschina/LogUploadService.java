package com.turman.oschina;

import android.content.Intent;
import android.os.IBinder;

import com.turman.oschina.base.BaseService;
import com.turman.oschina.utils.StringUtils;

import org.kymjs.kjframe.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class LogUploadService extends BaseService {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final File log = FileUtils.getSaveFile("OSChina", "OSCLog.log");
        String data = null;
        try {
            FileInputStream inputStream = new FileInputStream(log);
            data = StringUtils.toConvertString(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!StringUtils.isEmpty(data)) {
            Map<String, String> params = new HashMap<>();
            params.put("msg",data);
            params.put("report","1");
            params.put("app","1");
            addTask(Observable.just(params)
            .flatMap(new Func1<Map<String, String>, Observable<String>>() {
                @Override
                public Observable<String> call(Map<String, String> stringStringMap) {
                    return mOSChinaService.uploadLog(stringStringMap.get("msg"),stringStringMap.get("app"),stringStringMap.get("report"));
                }
            }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<String>() {
                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable e) {
                    e.printStackTrace();
                }

                @Override
                public void onNext(String s) {
                    if (s.equals("success"))
                        log.delete();
                    LogUploadService.this.stopSelf();
                }
            }));
        } else {
            LogUploadService.this.stopSelf();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
