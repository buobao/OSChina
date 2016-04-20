package com.turman.oschina.bean.list;

import com.turman.oschina.bean.base.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 留言实体类列表
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月22日 下午4:38:49
 *
 */
@SuppressWarnings("serial")
public class MessageList extends Entity implements ListEntity<Messages> {

	public int pageSize;
	public int messageCount;
	public List<Messages> messagelist = new ArrayList<Messages>();

	@Override
	public List<Messages> getList() {
		return messagelist;
	}
}
