package com.turman.oschina.bean.list;

import com.turman.oschina.bean.User;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * 好友实体类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年11月6日 上午11:17:36
 * 
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class FindUserList extends Entity implements ListEntity<User> {

	public final static int TYPE_FANS = 0x00;
	public final static int TYPE_FOLLOWER = 0x01;

	@ElementList(required = false)
	public List<User> users = new ArrayList<User>();

	@Override
	public List<User> getList() {
		return users;
	}
}
