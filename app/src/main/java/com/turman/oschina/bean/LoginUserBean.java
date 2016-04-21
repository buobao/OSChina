package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;

/** 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年9月27日 下午2:45:57 
 * 
 */

@SuppressWarnings("serial")
@Root(name = "oschina")
@Default(value = DefaultType.FIELD,required = false)
public class LoginUserBean extends Entity {
	public Result result;
	public User user;
}