package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Comment;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;


/**
 * 博客评论列表实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月17日 上午10:28:04
 *
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
@Default(value = DefaultType.FIELD,required = false)
public class BlogCommentList extends Entity implements ListEntity<Comment> {

	public int pagesize;
	public int allCount;
	public List<Comment> commentlist = new ArrayList<Comment>();

	@Override
	public List<Comment> getList() {
		return commentlist;
	}
}
