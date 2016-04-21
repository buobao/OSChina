package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

/**
 * 活动实体类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年12月12日 下午3:18:08
 * 
 */
@SuppressWarnings("serial")
@Root(name = "event")
@Default(value = DefaultType.FIELD, required = false)
public class Event extends Entity {
	@Transient
	public final static int EVNET_STATUS_APPLYING = 0x02;
	@Transient
	public final static int EVNET_STATUS_END = 0x01;
	@Transient
	public final static int APPLYSTATUS_CHECKING = 0x00;// 审核中
	@Transient
	public final static int APPLYSTATUS_CHECKED = 0x01;// 已经确认
	@Transient
	public final static int APPLYSTATUS_ATTEND = 0x02;// 已经出席
	@Transient
	public final static int APPLYSTATUS_CANCLE = 0x03;// 已取消
	@Transient
	public final static int APPLYSTATUS_REJECT = 0X04;// 已拒绝


	public String cover;
	public String title;
	public String url;
	public String createTime;
	public String startTime;
	public String endTime;
	public String spot;
	public int actor_count;
	public String location;
	public String city;
	public int status;
	public int applyStatus;
	public int category;// 活动类型 1源创会 2技术交流 3其他 4站外活动
	public EventRemark remark;
}
