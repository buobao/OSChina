package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Friend;
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
public class FriendsList extends Entity implements ListEntity<Friend> {

    public final static int TYPE_FANS = 0x00;
    public final static int TYPE_FOLLOWER = 0x01;
    @ElementList(required = false)
    public List<Friend> friends = new ArrayList<Friend>();

    @Override
    public List<Friend> getList() {
	return friends;
    }
}
