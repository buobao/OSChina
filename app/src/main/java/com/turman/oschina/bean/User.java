package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

/**
 * 登录用户实体类
 * 
 * @author liux (http://my.oschina.net/liux)
 * @version 1.0
 * @created 2012-3-21
 */
@SuppressWarnings("serial")
public class User extends Entity {

    public final static int RELATION_ACTION_DELETE = 0x00;// 取消关注
    public final static int RELATION_ACTION_ADD = 0x01;// 加关注

    public final static int RELATION_TYPE_BOTH = 0x01;// 双方互为粉丝
    public final static int RELATION_TYPE_FANS_HIM = 0x02;// 你单方面关注他
    public final static int RELATION_TYPE_NULL = 0x03;// 互不关注
    public final static int RELATION_TYPE_FANS_ME = 0x04;// 只有他关注我

    public String location;
    public String name;
    public int followers;
    public int fans;
    public int score;
    public String portrait;
    public String jointime;
    public String gender;
    public String devplatform;
    public String expertise;
    public int relation;
    public String latestonline;
    public String from;
    public int favoritecount;

    private String account;

    private String pwd;

    private boolean isRememberMe;

    @Override
    public String toString() {
	return "User [uid=" + id + ", location=" + location + ", name=" + name
		+ ", followers=" + followers + ", fans=" + fans + ", score="
		+ score + ", portrait=" + portrait + ", jointime=" + jointime
		+ ", gender=" + gender + ", devplatform=" + devplatform
		+ ", expertise=" + expertise + ", relation=" + relation
		+ ", latestonline=" + latestonline + ", from=" + from
		+ ", favoritecount=" + favoritecount + ", account=" + account
		+ ", pwd=" + pwd + ", isRememberMe=" + isRememberMe + "]";
    }
}
