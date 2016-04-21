package com.turman.oschina.bean.list;

import com.turman.oschina.bean.TweetLike;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * LikeTweetList.java
 * 
 * @author 火蚁(http://my.oschina.net/u/253900)
 *
 * @data 2015-4-10 上午10:11:48
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class TweetLikeList implements ListEntity<TweetLike> {
    @ElementList(required = false)
    public List<TweetLike> likeList;
    
    @Override
    public List<TweetLike> getList() {
	    return likeList;
    }
}

