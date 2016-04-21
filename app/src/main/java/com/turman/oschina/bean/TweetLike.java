package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;

/**
 * 点赞消息实体类
 * LikeTweet.java
 * 
 * @author 火蚁(http://my.oschina.net/u/253900)
 *
 * @data 2015-4-10 上午10:09:15
 */
@SuppressWarnings("serial")
@Root(name = "mytweet")
@Default(value = DefaultType.FIELD,required = false)
public class TweetLike extends Entity {
    private User user;
    private Tweet tweet;
    private String datatime;
    private int appclient;
}

