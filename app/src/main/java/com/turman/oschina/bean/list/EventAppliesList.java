package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Apply;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动参与者列表实体类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年12月12日 下午8:06:30
 *
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class EventAppliesList extends Entity implements ListEntity<Apply> {

	public final static int TYPE_FANS = 0x00;
	public final static int TYPE_FOLLOWER = 0x01;

	@ElementList(required = false)
	private List<Apply> applies = new ArrayList<Apply>();

	@Override
	public List<Apply> getList() {
		return applies;
	}
}
