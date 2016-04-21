package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Base;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/** 
 * 我的资料实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月30日 下午4:08:30 
 * 
 */

@SuppressWarnings("serial")
@Root(name = "oschina")
public class MyInformation extends Base {
	@Element(required = false)
	private User user;
}
