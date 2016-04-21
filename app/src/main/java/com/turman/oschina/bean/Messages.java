package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

/**
 * 留言实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月22日 下午4:43:01
 *
 */
@SuppressWarnings("serial")
@Root(name = "message")
@Default(value = DefaultType.FIELD,required = false)
public class Messages extends Entity {
	@Transient
	public final static int CLIENT_MOBILE = 2;
	@Transient
	public final static int CLIENT_ANDROID = 3;
	@Transient
	public final static int CLIENT_IPHONE = 4;
	@Transient
	public final static int CLIENT_WINDOWS_PHONE = 5;

	public String portrait;
	public int friendid;
	public String friendname;
	public String sender;
	public int senderid;
	public String content;
	public int messageCount;
	public String pubDate;
	public int appClient;
}
