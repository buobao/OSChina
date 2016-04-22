package com.turman.oschina;

import android.content.Intent;
import android.os.IBinder;

import com.turman.oschina.base.BaseService;
import com.turman.oschina.utils.StringUtils;

import org.kymjs.kjframe.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
        data = "load error";
        if (!StringUtils.isEmpty(data)) {
            final String finalData = data;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mOSChinaService.uploadLog(finalData,"1","1");
                }
            }).start();
            mOSChinaService.uploadLog(data,"1","1");
//            Call<String> call = mOSChinaService.uploadLog(data,"1","1");
//            call.enqueue(new Callback<String>() {
//                @Override
//                public void onResponse(Call<String> call, Response<String> response) {
//                    String result = response.body();
//                    if ("success".equals(result)) {
//                        log.delete();
//                        LogUploadService.this.stopSelf();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<String> call, Throwable t) {
//
//                }
//            });
        } else {
            LogUploadService.this.stopSelf();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
