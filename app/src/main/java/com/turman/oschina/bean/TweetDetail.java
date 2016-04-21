package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author HuangWenwei
 *
 * @date 2014年10月16日
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class TweetDetail extends Entity {
	@Element(required = false)
	private Tweet tweet;
}
