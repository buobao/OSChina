package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Post;
import com.turman.oschina.bean.base.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 帖子实体类列表
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月9日 下午6:10:11
 *
 */
@SuppressWarnings("serial")
public class PostList extends Entity implements ListEntity<Post> {
	
	public final static String PREF_READED_POST_LIST = "readed_post_list.pref";

	public int pageSize;
	public int postCount;
	public List<Post> postlist = new ArrayList<Post>();
	@Override
	public List<Post> getList() {
		return postlist;
	}
}
