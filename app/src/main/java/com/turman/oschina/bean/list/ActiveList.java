package com.turman.oschina.bean.list;

import com.turman.oschina.bean.Active;
import com.turman.oschina.bean.Result;
import com.turman.oschina.bean.base.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dqf on 2016/4/20.
 */
@SuppressWarnings("serial")
public class ActiveList extends Entity implements ListEntity<Active> {
    public final static int CATALOG_LASTEST = 1;// 最新
    public final static int CATALOG_ATME = 2;// @我
    public final static int CATALOG_COMMENT = 3;// 评论
    public final static int CATALOG_MYSELF = 4;// 我自己

    public int pageSize;
    public int activeCount;
    public List<Active> activelist = new ArrayList<Active>();
    public Result result;

    @Override
    public List<Active> getList() {
        return activelist;
    }
}
