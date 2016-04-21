package com.turman.oschina.bean.list;

import com.turman.oschina.bean.User;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * TweetLikeUserList.java
 * 
 * @author 火蚁(http://my.oschina.net/u/253900)
 *
 * @data 2015-3-26 下午4:23:32
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class TweetLikeUserList implements ListEntity<User> {
    @ElementList(required = false)
    public List<User> likeList = new ArrayList<User>();

    public List<User> getList() {
        return likeList;
    }
}

