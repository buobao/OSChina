package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

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
public class Post extends Entity {

	public final static int CATALOG_ASK = 1;
	public final static int CATALOG_SHARE = 2;
	public final static int CATALOG_OTHER = 3;
	public final static int CATALOG_JOB = 4;
	public final static int CATALOG_SITE = 5;

	public String title;
	public String portrait;
	public String url;
	public String body;
	public String author;
	public int authorId;
	public int answerCount;
	public int viewCount;
	public String pubDate;
	public int catalog;
	public int isNoticeMe;
	public int favorite;
	public Tags tags;
	public Answer answer;
	public Event event;

	public class Answer implements Serializable {
		public String name;
		public String time;
	}
	
	public class Tags implements Serializable {
		public List<String> tags;
	}
}
