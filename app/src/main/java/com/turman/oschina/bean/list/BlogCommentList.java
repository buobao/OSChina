package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Comment;
import com.turman.oschina.bean.base.Entity;

import java.util.ArrayList;
import java.util.List;


/**
 * 博客评论列表实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月17日 上午10:28:04
 *
 */
@SuppressWarnings("serial")
public class BlogCommentList extends Entity implements ListEntity<Comment> {

	public int pageSize;
	public int allCount;
	public List<Comment> commentlist = new ArrayList<Comment>();

	@Override
	public List<Comment> getList() {
		return commentlist;
	}
}
