package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Favorite;
import com.turman.oschina.bean.base.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 收藏实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月14日 下午2:27:39
 *
 */
@SuppressWarnings("serial")
public class FavoriteList extends Entity implements ListEntity<Favorite> {

	public final static int TYPE_ALL = 0x00;
	public final static int TYPE_SOFTWARE = 0x01;
	public final static int TYPE_POST = 0x02;
	public final static int TYPE_BLOG = 0x03;
	public final static int TYPE_NEWS = 0x04;
	public final static int TYPE_CODE = 0x05;

	public int pageSize;
	public List<Favorite> favoritelist = new ArrayList<Favorite>();

	@Override
	public List<Favorite> getList() {
		return favoritelist;
	}
}
