package com.turman.oschina.bean.list;

import com.turman.oschina.bean.MessageDetail;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天详细信息实体类
 * @author 铂金小鸟（http://my.oschina.net/fants）
 * @Created 2015年9月16日 上午4:20:01
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class MessageDetailList extends Entity implements ListEntity<MessageDetail> {
    @Element(required = false)
    public int allCount;
    @Element(required = false)
    public int pagesize;
    @ElementList(required = false)
    public List<MessageDetail> messages = new ArrayList<MessageDetail>();

    @Override
    public List<MessageDetail> getList() {
        return messages;
    }

}
