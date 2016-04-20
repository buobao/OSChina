package com.turman.oschina.utils.net;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dqf on 2016/4/20.
 */
public class NetRetrofitClient {
    private Retrofit client = null;

    @Inject
    public NetRetrofitClient(OkHttpClient okHttpClient){
        client = new Retrofit.Builder()
                .baseUrl(UrlHelper.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}






















































