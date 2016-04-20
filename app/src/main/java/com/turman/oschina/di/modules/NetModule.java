package com.turman.oschina.di.modules;

import com.turman.oschina.utils.net.UrlHelper;
import com.turman.oschina.utils.net.service.OSChinaService;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by dqf on 2016/4/20.
 */
@Module
public class NetModule {

    @Provides @Singleton
    public OkHttpClient providesOkHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();  //拦截器,用于输出网络请求和结果的 Log
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);            //级别设置,另：BASIC / HEADERS

        //这里是自定义的拦截器，在所有请求的header加上相应的请求token
        Interceptor mTokenInterceptor = new Interceptor() {
            @Override public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
//                if (Your.sToken == null || alreadyHasAuthorizationHeader(originalRequest)) {
//                    return chain.proceed(originalRequest);
//                }
                Request authorised = originalRequest.newBuilder()
                        .header("Accept-Language", Locale.getDefault().toString())
                        .header("Host", UrlHelper.HOST)
                        .header("Connection","Keep-Alive")
                        .build();
                return chain.proceed(authorised);
            }
        };

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .addNetworkInterceptor(mTokenInterceptor)
                .build();
        return client;
    }

    @Provides @Singleton
    public Retrofit providesRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(UrlHelper.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                //.addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides @Singleton
    public OSChinaService providesOSChinaService(Retrofit retrofit){
        return retrofit.create(OSChinaService.class);
    }
}
