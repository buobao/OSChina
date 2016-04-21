package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Base;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;

import java.util.List;

/** 
 * 个人信息专用实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月29日 上午10:53:54 
 * 
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
@Default(value = DefaultType.FIELD,required = false)
public class UserInformation extends Base {
	public User user;
	public int pagesize;
	public List<Active> activies;
}