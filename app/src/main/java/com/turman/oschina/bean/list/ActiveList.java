package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Active;
import com.turman.oschina.bean.Result;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dqf on 2016/4/20.
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class ActiveList extends Entity implements ListEntity<Active> {
    public final static int CATALOG_LASTEST = 1;// 最新
    public final static int CATALOG_ATME = 2;// @我
    public final static int CATALOG_COMMENT = 3;// 评论
    public final static int CATALOG_MYSELF = 4;// 我自己

    @Element(required = false)
    public int pageSize;
    @Element(required = false)
    public int activeCount;
    @Element(required = false)
    public List<Active> activies = new ArrayList<Active>();
    @Element(required = false)
    public Result result;

    @Override
    public List<Active> getList() {
        return activies;
    }
}
