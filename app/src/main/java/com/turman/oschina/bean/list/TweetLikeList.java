package com.turman.oschina.bean.list;

import com.turman.oschina.bean.TweetLike;

import java.util.List;

/**
 * LikeTweetList.java
 * 
 * @author 火蚁(http://my.oschina.net/u/253900)
 *
 * @data 2015-4-10 上午10:11:48
 */
@SuppressWarnings("serial")
public class TweetLikeList implements ListEntity<TweetLike> {

    public List<TweetLike> list;
    
    @Override
    public List<TweetLike> getList() {
	    return list;
    }
}

