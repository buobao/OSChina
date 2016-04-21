package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 收藏实体类
 * @author hww
 *
 */
@SuppressWarnings("serial")
@Root(name = "favorite")
public class Favorite extends Entity {
	
	public static final int CATALOG_ALL = 0;
	public static final int CATALOG_SOFTWARE = 1;
	public static final int CATALOG_TOPIC = 2;
	public static final int CATALOG_BLOGS = 3;
	public static final int CATALOG_NEWS = 4;
	public static final int CATALOG_CODE = 5;

	@Element(required = false)
	public int objid;
	@Element(required = false)
	public int type;
	@Element(required = false)
	public String title;
	@Element(required = false)
	public String url;
}
