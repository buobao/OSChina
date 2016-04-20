package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

/**
 * 活动报名实体类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年12月17日 下午3:13:07
 * 
 */
@SuppressWarnings("serial")
public class EventApplyData extends Entity {

	public int event;// 活动的id
	public int user;// 用户的id
	public String name;// 名字
	public String gender;// 性别
	public String mobile;// 电话
	public String company;// 单位名称
	public String job;// 职业名称
	public String remark;// 备注
}
