package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 软件详情实体类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月23日 下午3:10:54
 * 
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class SoftwareDetail extends Entity {
	@Element(required = false)
	public Software software;
}
