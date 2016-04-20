package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import java.io.Serializable;

/**
 * 动态实体类
 * Created by dqf on 2016/4/20.
 */
@SuppressWarnings("serial")
public class Active extends Entity {
    public final static int CATALOG_OTHER = 0;// 其他
    public final static int CATALOG_NEWS = 1;// 新闻
    public final static int CATALOG_POST = 2;// 帖子
    public final static int CATALOG_TWEET = 3;// 动弹
    public final static int CATALOG_BLOG = 4;// 博客

    public final static int CLIENT_MOBILE = 2;
    public final static int CLIENT_ANDROID = 3;
    public final static int CLIENT_IPHONE = 4;
    public final static int CLIENT_WINDOWS_PHONE = 5;

    public String portrait;
    public String message;
    public String author;
    public int authorId;
    public int activeType;
    public int objectId;
    public int catalog;
    public int objectType;
    public int objectCatalog;
    public String objectTitle;
    public ObjectReply objectReply;
    public int commentCount;
    public String pubDate;
    public String tweetimage;
    public String tweetattach;
    public int appClient;
    public String url;

    public static class ObjectReply implements Serializable {
        public String objectName;
        public String objectBody;
    }

}














































