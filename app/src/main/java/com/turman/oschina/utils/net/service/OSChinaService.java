package com.turman.oschina.utils.net.service;

import com.turman.oschina.bean.LoginUserBean;
import com.turman.oschina.bean.TweetLike;
import com.turman.oschina.bean.list.ActiveList;
import com.turman.oschina.bean.list.BlogList;
import com.turman.oschina.bean.list.FavoriteList;
import com.turman.oschina.bean.list.FriendsList;
import com.turman.oschina.bean.list.NewsList;
import com.turman.oschina.bean.list.PostList;
import com.turman.oschina.bean.list.SoftwareCatalogList;
import com.turman.oschina.bean.list.TweetLikeList;
import com.turman.oschina.bean.list.TweetsList;
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

    @GET(UrlHelper.BLOG_LIST)
    Observable<BlogList> getBlogList(@Query("type") String type, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);


    @GET(UrlHelper.POST_LIST)
    Observable<PostList> getPostList(@Query("catalog") int catalog, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET(UrlHelper.POST_LIST)
    Observable<PostList> getPostListByTag(@Query("tag") String tag, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET(UrlHelper.TWEET_LIST)
    Observable<TweetsList> getTweetList(@Query("uid") int uid, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET(UrlHelper.TWEET_TOPIC_LIST)
    Observable<TweetsList> getTweetTopicList(@Query("title") String title, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET(UrlHelper.MY_TWEET_LIKE_LIST)
    Observable<TweetLikeList> getTweetLikeList();

    @GET(UrlHelper.TWEET_LIKE)
    Observable<TweetLike> pubLikeTweet(@Query("tweetid") int tweetid, @Query("uid") int uid, @Query("ownerOfTweet") int ownerOfTweet);

    @GET(UrlHelper.TWEET_UNLIKE)
    Observable<TweetLike> pubUnLikeTweet(@Query("tweetid") int tweetid, @Query("uid") int uid, @Query("ownerOfTweet") int ownerOfTweet);

    @GET(UrlHelper.TWEET_LIKE_LIST)
    Observable<TweetLikeList> getTweetLikeList(@Query("tweetid") int tweetid, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET(UrlHelper.ACTIVE_LIST)
    Observable<ActiveList> getActiveList(@Query("uid") int uid, @Query("catalog") int catalog, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET(UrlHelper.FRIENDS_LIST)
    Observable<FriendsList> getFriendList(@Query("uid") int uid, @Query("relation") int relation, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    /**
     * 获取所有关注好友列表
     * @param uid
     * @param relation
     * @param all
     * @return
     */
    @GET(UrlHelper.FRIENDS_LIST)
    Observable<FriendsList> getAllFriendsList(@Query("uid") int uid, @Query("relation") int relation,@Query("all") int all);

    /**
     * 获取用户收藏
     * @param uid 指定用户UID
     * @param type 收藏类型: 0:全部收藏　1:软件　2:话题　3:博客　4:新闻　5:代码
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GET(UrlHelper.FAVORITE_LIST)
    Observable<FavoriteList> getFavoriteList(@Query("uid") int uid, @Query("type") int type, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    /**
     * 分类列表
     * @param tag 第一级:0
     * @return
     */
    @GET(UrlHelper.SOFTWARECATALOG_LIST)
    Observable<SoftwareCatalogList> getSoftwareCatalogList(@Query("tag") int tag);
}



























































