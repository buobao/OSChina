package com.turman.oschina.bean.list;

import com.turman.oschina.bean.SoftwareDec;
import com.turman.oschina.bean.base.Entity;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class SoftwareList extends Entity implements ListEntity<SoftwareDec> {
	
	public final static String PREF_READED_SOFTWARE_LIST = "readed_software_list.pref";
	
	public final static String CATALOG_RECOMMEND = "recommend";
	public final static String CATALOG_TIME = "time";
	public final static String CATALOG_VIEW = "view";
	public final static String CATALOG_LIST_CN = "list_cn";

	public int softwarecount;
	public int pagesize;
	public List<SoftwareDec> softwarelist = new ArrayList<SoftwareDec>();

	@Override
	public List<SoftwareDec> getList() {
		return softwarelist;
	}
}
