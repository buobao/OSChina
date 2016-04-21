package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

/**
 * 登录用户实体类
 * 
 * @author liux (http://my.oschina.net/liux)
 * @version 1.0
 * @created 2012-3-21
 */
@SuppressWarnings("serial")
@Root(name = "user")
@Default(value = DefaultType.FIELD,required = false)
public class User extends Entity {
    @Transient
    public final static int RELATION_ACTION_DELETE = 0x00;// 取消关注
    @Transient
    public final static int RELATION_ACTION_ADD = 0x01;// 加关注
    @Transient
    public final static int RELATION_TYPE_BOTH = 0x01;// 双方互为粉丝
    @Transient
    public final static int RELATION_TYPE_FANS_HIM = 0x02;// 你单方面关注他
    @Transient
    public final static int RELATION_TYPE_NULL = 0x03;// 互不关注
    @Transient
    public final static int RELATION_TYPE_FANS_ME = 0x04;// 只有他关注我

    public int uid;
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

    @Transient
    public String account;
    @Transient
    public String pwd;
    @Transient
    public boolean isRememberMe;

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
