package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;

/**
 * 搜索结果实体类
 */
@SuppressWarnings("serial")
@Root(name = "result")
@Default(value = DefaultType.FIELD,required = false)
public class SearchResult extends Entity {
	public String objid;
	public String type;
	public String title;
	public String description;
	public String url;
	public String pubDate;
	public String author;
}
