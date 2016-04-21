package com.turman.oschina.bean.list;

import com.turman.oschina.bean.SearchResult;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索实体类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年12月5日 上午11:19:44
 * 
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class SearchList extends Entity implements ListEntity<SearchResult> {

	public final static String CATALOG_ALL = "all";
	public final static String CATALOG_NEWS = "news";
	public final static String CATALOG_POST = "post";
	public final static String CATALOG_SOFTWARE = "software";
	public final static String CATALOG_BLOG = "blog";

	@Element(required = false)
	public int pagesize;
	@ElementList(required = false)
	public List<SearchResult> results = new ArrayList<SearchResult>();

	@Override
	public List<SearchResult> getList() {
		return results;
	}
}
