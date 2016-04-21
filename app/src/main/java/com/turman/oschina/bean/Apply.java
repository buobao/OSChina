package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;

/**
 * 活动报名者实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2015年1月16日 下午3:27:04 
 * 
 */
@SuppressWarnings("serial")
@Root(name = "apply")
@Default(DefaultType.FIELD)
public class Apply extends Entity {
	public int userid;
	public String name;
	public String portrait;
	public String company;
	public String job;
}

