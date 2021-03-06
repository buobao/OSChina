package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Event;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动实体类列表
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年12月10日 下午2:28:54
 * 
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class EventList extends Entity implements ListEntity<Event> {

	public final static int EVENT_LIST_TYPE_NEW_EVENT = 0X00;// 近期活动

	public final static int EVENT_LIST_TYPE_MY_EVENT = 0X01;// 我的活动

	@ElementList(required = false)
	public List<Event> events = new ArrayList<Event>();

	@Override
	public List<Event> getList() {
		return events;
	}
}
