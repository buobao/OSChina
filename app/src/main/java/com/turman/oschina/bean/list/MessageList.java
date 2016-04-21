package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Messages;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * 留言实体类列表
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月22日 下午4:38:49
 *
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class MessageList extends Entity implements ListEntity<Messages> {
	@Element(required = false)
	public int pagesize;
	@Element(required = false)
	public int messageCount;
	@ElementList(required = false)
	public List<Messages> messages = new ArrayList<Messages>();

	@Override
	public List<Messages> getList() {
		return messages;
	}
}
