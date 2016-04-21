package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

import java.io.Serializable;
import java.util.List;

/**
 * 帖子实体类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月9日 下午6:02:47
 * 
 */
@SuppressWarnings("serial")
@Root(name = "post")
@Default(value = DefaultType.FIELD, required = false)
public class Post extends Entity {
	@Transient
	public final static int CATALOG_ASK = 1;
	@Transient
	public final static int CATALOG_SHARE = 2;
	@Transient
	public final static int CATALOG_OTHER = 3;
	@Transient
	public final static int CATALOG_JOB = 4;
	@Transient
	public final static int CATALOG_SITE = 5;

	public String title;
	public String portrait;
	public String url;
	public String body;
	public String author;
	public int authorid;
	public int answerCount;
	public int viewCount;
	public String pubDate;
	public int catalog;
	public int isnoticeme;
	public int favorite;
	public Tags tags;
	public Answer answer;
	public Event event;

	@Root(name = "answer")
	@Default(value = DefaultType.FIELD, required = false)
	public static class Answer implements Serializable {
		public String name;
		public String time;
	}

	@Root(name = "tags")
	public static class Tags implements Serializable {
		@ElementList(required = false)
		public List<String> tags;
	}
}
