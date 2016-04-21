package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Post;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * 帖子实体类列表
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月9日 下午6:10:11
 *
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class PostList extends Entity implements ListEntity<Post> {
	
	public final static String PREF_READED_POST_LIST = "readed_post_list.pref";
	@Element(required = false)
	public int pagesize;
	@Element(required = false)
	public int postCount;
	@ElementList(required = false)
	public List<Post> posts = new ArrayList<Post>();
	@Override
	public List<Post> getList() {
		return posts;
	}
}
