package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Tweet;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuangWenwei
 *
 * @date 2014年10月10日
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class TweetsList extends Entity implements ListEntity<Tweet> {
	
    public final static int CATALOG_LATEST = 0;
    public final static int CATALOG_HOT = -1;
    public final static int CATALOG_ME = 1;
	@Element(required = false)
	public int tweetcount;
	@Element(required = false)
	public int pagesize;
	@ElementList(required = false)
	public List<Tweet> tweets = new ArrayList<Tweet>();

	@Override
	public List<Tweet> getList() {
		return tweets;
	}

}
