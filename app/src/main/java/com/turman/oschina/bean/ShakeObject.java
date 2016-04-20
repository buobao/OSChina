package com.turman.oschina.bean;

public class ShakeObject {

    public String randomtype; // 数据类型
    public String id; // 数据id
    public String title; // 帖子标题
    public String detail; // 内容
    public String author; // 作者
    public String authorid; // 作者id
    public String image; // 头像地址
    public String pubDate; // 收录日期
    public String commentCount;
    public String url;

    public static final String RANDOMTYPE_NEWS = "1";
    public static final String RANDOMTYPE_BLOG = "2";
    public static final String RANDOMTYPE_SOFTWARE = "3";
}
