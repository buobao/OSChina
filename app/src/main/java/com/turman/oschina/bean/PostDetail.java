package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/** 
 * 帖子详情
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月11日 下午3:28:33 
 * 
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class PostDetail extends Entity {
	@Element(required = false)
	public Post post;

}
