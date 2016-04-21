package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 博客详情
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月15日 上午10:51:11
 *
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class BlogDetail extends Entity {
	@Element(required = false)
	public Blog blog;
}
