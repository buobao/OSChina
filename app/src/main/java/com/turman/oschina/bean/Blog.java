package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

/**
 * @author HuangWenwei
 * 
 * @date 2014年9月29日
 */
@SuppressWarnings("serial")
@Root(name = "blog")
@Default(DefaultType.FIELD)
public class Blog extends Entity {
	@Transient
	public final static int DOC_TYPE_REPASTE = 0;//转帖
	@Transient
	public final static int DOC_TYPE_ORIGINAL = 1;//原创

	public String title;
	public String url;
	public String where;
	public int commentCount;
	public String body;
	public String authorname;
	public int authoruid;
	public int documentType;
	public String pubDate;
	public int favorite;
}
