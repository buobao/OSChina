package com.turman.oschina.bean.list;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * 开源软件分类列表实体
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年12月2日 上午10:54:10
 *
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class SoftwareCatalogList extends Entity implements ListEntity {
	@Element(required = false)
	public int softwarecount;
	@ElementList(required = false)
	public List<SoftwareType> softwareTypes = new ArrayList<SoftwareType>();

	@Override
	public List<?> getList() {
		return softwareTypes;
	}

	public class SoftwareType extends Entity {
		private String name;
		private int tag;
	}

}
