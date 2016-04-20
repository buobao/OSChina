package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Tweet;
import com.turman.oschina.bean.base.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuangWenwei
 *
 * @date 2014年10月10日
 */
@SuppressWarnings("serial")
public class TweetsList extends Entity implements ListEntity<Tweet> {
	
    public final static int CATALOG_LATEST = 0;
    public final static int CATALOG_HOT = -1;
    public final static int CATALOG_ME = 1;

	public int tweetCount;
	public int pagesize;
	public List<Tweet> tweetslist = new ArrayList<Tweet>();

	@Override
	public List<Tweet> getList() {
		return tweetslist;
	}

}
