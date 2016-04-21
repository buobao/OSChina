package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * 动态实体类
 * Created by dqf on 2016/4/20.
 */
@SuppressWarnings("serial")
@Root(name = "active")
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

    @Element(required = false)
    public String portrait;
    @Element(required = false)
    public String message;
    @Element(required = false)
    public String author;
    @Element(required = false)
    public int authorid;
    @Element(required = false)
    public int activetype;
    @Element(required = false)
    public int objectID;
    @Element(required = false)
    public int catalog;
    @Element(required = false)
    public int objecttype;
    @Element(required = false)
    public int objectcatalog;
    @Element(required = false)
    public String objecttitle;
    @Element(required = false)
    public ObjectReply objectreply;
    @Element(required = false)
    public int commentCount;
    @Element(required = false)
    public String pubDate;
    @Element(required = false)
    public String tweetimage;
    @Element(required = false)
    public String tweetattach;
    @Element(required = false)
    public int appclient;
    @Element(required = false)
    public String url;

    @Root(name = "objectreply")
    @Default(value = DefaultType.FIELD,required = false)
    public static class ObjectReply implements Serializable {
        public String objectName;
        public String objectBody;
    }

}














































