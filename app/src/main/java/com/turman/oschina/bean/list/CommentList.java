package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Comment;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 评论列表实体类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月14日 下午3:32:39
 * 
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class CommentList extends Entity implements ListEntity<Comment> {

    public final static int CATALOG_NEWS = 1;
    public final static int CATALOG_POST = 2;
    public final static int CATALOG_TWEET = 3;
    public final static int CATALOG_ACTIVE = 4;
    public final static int CATALOG_MESSAGE = 4;// 动态与留言都属于消息中心

    @Element(required = false)
    public int pagesize;
    @Element(required = false)
    public int allCount;
    @ElementList(required = false)
    public final List<Comment> comments = new ArrayList<Comment>();


    @Override
    public List<Comment> getList() {
        return comments;
    }

    public void sortList() {
        Collections.sort(comments, new Comparator<Comment>() {

            @Override
            public int compare(Comment lhs, Comment rhs) {
                return lhs.pubDate.compareTo(rhs.pubDate);
            }
        });
    }
}
