package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Blog;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuangWenwei
 *
 * @date 2014年9月28日
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class BlogList extends Entity implements ListEntity<Blog> {
	
	public final static String PREF_READED_BLOG_LIST = "readed_blog_list.pref";
	
	public static final String CATALOG_LATEST = "latest";
	public static final String  CATALOG_RECOMMEND = "recommend";

	@Element(required = false)
	private int pagesize;
	@ElementList(required = false)
	private List<Blog> blogs = new ArrayList<Blog>();
	@Element(required = false)
	private int blogsCount;

	@Override
	public List<Blog> getList() {
		return blogs;
	}
}
