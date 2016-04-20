package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Apply;
import com.turman.oschina.bean.base.Entity;

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
public class EventAppliesList extends Entity implements ListEntity<Apply> {

	public final static int TYPE_FANS = 0x00;
	public final static int TYPE_FOLLOWER = 0x01;

	private List<Apply> list = new ArrayList<Apply>();

	@Override
	public List<Apply> getList() {
		return list;
	}
}
