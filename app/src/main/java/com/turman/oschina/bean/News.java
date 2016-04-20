package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 新闻、软件、帖子、博客实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年9月28日 上午10:16:59
 *
 */
@SuppressWarnings("serial")
public class News extends Entity {
	
	public final static int NEWSTYPE_NEWS = 0x00;//0 新闻
	public final static int NEWSTYPE_SOFTWARE = 0x01;//1 软件
	public final static int NEWSTYPE_POST = 0x02;//2 帖子
	public final static int NEWSTYPE_BLOG = 0x03;//3 博客

	public String title;
	public String url;
	public String body;
	public String author;
	public int authorId;
	public int commentCount;
	public String pubDate;
	public String softwareLink;
	public String softwareName;
	public int favorite;
	public NewsType newsType;
	public List<Relative> relatives = new ArrayList<Relative>();

	public class NewsType implements Serializable{
		public int type;
		public String attachment;
		public int authoruid2;
		public String eventUrl;
	} 

	public class Relative implements Serializable{
		public String title;
		public String url;
	} 
}
