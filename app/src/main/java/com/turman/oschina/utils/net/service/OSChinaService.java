package com.turman.oschina.utils.net.service;

import com.turman.oschina.bean.LoginUserBean;
import com.turman.oschina.bean.list.NewsList;
import com.turman.oschina.utils.net.UrlHelper;

import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dqf on 2016/4/20.
 */
public interface OSChinaService {

    /**
     * 登录
     * @param username
     * @param pwd
     * @param keep_login
     * @return
     */
    @POST(UrlHelper.LOGIN)
    Observable<LoginUserBean> login(@Field("username") String username, @Field("pwd") String pwd, @Field("keep_login") int keep_login);

    /**
     * 读取新闻列表
     * @param catalog
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GET(UrlHelper.NEWS_LIST)
    Observable<NewsList> getNewsList(@Query("catalog") int catalog, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

}
