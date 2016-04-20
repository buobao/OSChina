package com.turman.oschina.bean.list;

import com.turman.oschina.bean.MessageDetail;
import com.turman.oschina.bean.base.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天详细信息实体类
 * @author 铂金小鸟（http://my.oschina.net/fants）
 * @Created 2015年9月16日 上午4:20:01
 */
@SuppressWarnings("serial")
public class MessageDetailList extends Entity implements ListEntity<MessageDetail> {

    public int allCount;
    public int pageSize;
    public List<MessageDetail> messagelist = new ArrayList<MessageDetail>();

    @Override
    public List<MessageDetail> getList() {
        return messagelist;
    }

}
