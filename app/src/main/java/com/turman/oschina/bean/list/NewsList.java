package com.turman.oschina.bean.list;

import com.turman.oschina.bean.News;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻列表实体类
 * 		
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年9月27日 下午5:55:58
 *
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class NewsList extends Entity implements ListEntity<News> {
	
	public final static String PREF_READED_NEWS_LIST = "readed_news_list.pref";

	public final static int CATALOG_ALL = 1;
	public final static int CATALOG_INTEGRATION = 2;
	public final static int CATALOG_SOFTWARE = 3;
	
	public final static int CATALOG_WEEK = 4;
	public final static int CATALOG_MONTH = 5;

	@Element(required = false)
	public int catalog;
	@Element(required = false)
	public int pagesize;
	@Element(required = false)
	public int newsCount;
	@ElementList(required = false)
	public List<News> newslist = new ArrayList<News>();


	@Override
	public List<News> getList() {
		return newslist;
	}
}
