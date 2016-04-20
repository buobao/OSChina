package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Base;

import java.util.List;

/** 
 * 个人信息专用实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月29日 上午10:53:54 
 * 
 */
@SuppressWarnings("serial")
public class UserInformation extends Base {

	public User user;
	public int pageSize;
	public List<Active> activeList;
}