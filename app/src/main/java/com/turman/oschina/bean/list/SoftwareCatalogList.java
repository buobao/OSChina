package com.turman.oschina.bean.list;

import com.turman.oschina.bean.base.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 开源软件分类列表实体
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年12月2日 上午10:54:10
 *
 */
@SuppressWarnings("serial")
public class SoftwareCatalogList extends Entity implements ListEntity {

	public int softwarecount;
	public List<SoftwareType> softwarecataloglist = new ArrayList<SoftwareType>();

	@Override
	public List<?> getList() {
		return softwarecataloglist;
	}

	public class SoftwareType extends Entity {
		private String name;
		private int tag;
	}

}
