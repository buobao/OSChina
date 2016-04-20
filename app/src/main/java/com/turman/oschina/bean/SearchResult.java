package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

/**
 * 搜索结果实体类
 */
@SuppressWarnings("serial")
public class SearchResult extends Entity {
	public String type;
	public String title;
	public String description;
	public String url;
	public String pubDate;
	public String author;
}
