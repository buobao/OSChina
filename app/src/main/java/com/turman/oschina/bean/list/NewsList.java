package com.turman.oschina.bean.list;

import com.turman.oschina.bean.News;
import com.turman.oschina.bean.base.Entity;

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
public class NewsList extends Entity implements ListEntity<News> {
	
	public final static String PREF_READED_NEWS_LIST = "readed_news_list.pref";

	public final static int CATALOG_ALL = 1;
	public final static int CATALOG_INTEGRATION = 2;
	public final static int CATALOG_SOFTWARE = 3;
	
	public final static int CATALOG_WEEK = 4;
	public final static int CATALOG_MONTH = 5;

	public int catalog;
	public int pageSize;
	public int newsCount;
	public List<News> list = new ArrayList<News>();


	@Override
	public List<News> getList() {
		return list;
	}
}
