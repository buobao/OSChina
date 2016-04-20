package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

/**
 * 收藏实体类
 * @author hww
 *
 */
@SuppressWarnings("serial")
public class Favorite extends Entity {
	
	public static final int CATALOG_ALL = 0;
	public static final int CATALOG_SOFTWARE = 1;
	public static final int CATALOG_TOPIC = 2;
	public static final int CATALOG_BLOGS = 3;
	public static final int CATALOG_NEWS = 4;
	public static final int CATALOG_CODE = 5;

	public int type;
	public String title;
	public String url;
}
