package com.turman.oschina.bean.list;

import com.turman.oschina.bean.SoftwareDec;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Root(name = "oschina")
public class SoftwareList extends Entity implements ListEntity<SoftwareDec> {
	
	public final static String PREF_READED_SOFTWARE_LIST = "readed_software_list.pref";
	
	public final static String CATALOG_RECOMMEND = "recommend";
	public final static String CATALOG_TIME = "time";
	public final static String CATALOG_VIEW = "view";
	public final static String CATALOG_LIST_CN = "list_cn";

	@Element(required = false)
	public int softwarecount;
	@Element(required = false)
	public int pagesize;
	@ElementList(required = false)
	public List<SoftwareDec> softwares = new ArrayList<SoftwareDec>();

	@Override
	public List<SoftwareDec> getList() {
		return softwares;
	}
}
