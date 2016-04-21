package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;

/**
 * 好友实体类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年11月6日 上午11:37:31
 * 
 */
@SuppressWarnings("serial")
@Root(name = "friend")
@Default(value = DefaultType.FIELD, required = false)
public class Friend extends Entity {

    public int userid;
    public String name;
    public String from;
    public String portrait;
    public String expertise;
    public int gender;
}
