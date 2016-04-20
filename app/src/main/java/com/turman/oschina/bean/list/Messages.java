package com.turman.oschina.bean.list;

import com.turman.oschina.bean.base.Entity;

/**
 * 留言实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月22日 下午4:43:01
 *
 */
@SuppressWarnings("serial")
public class Messages extends Entity {

	public final static int CLIENT_MOBILE = 2;
	public final static int CLIENT_ANDROID = 3;
	public final static int CLIENT_IPHONE = 4;
	public final static int CLIENT_WINDOWS_PHONE = 5;

	public String portrait;
	public int friendId;
	public String friendName;
	public String sender;
	public int senderId;
	public String content;
	public int messageCount;
	public String pubDate;
	public int appClient;
}
