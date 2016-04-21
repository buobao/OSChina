package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

/**
 * 聊天详细信息实体类
 * @author 铂金小鸟（http://my.oschina.net/fants）
 * @Created 2015年9月16日 上午4:20:01
 */
@SuppressWarnings("serial")
@Root(name = "message")
@Default(value = DefaultType.FIELD, required = false)
public class MessageDetail extends Entity {

    //是否显示时间
    @Transient
    public boolean showDate;
    //消息状态
    @Transient
    public MessageStatus status;
    public String portrait;
    public String author;
    public int authorid;
    public String content;
    public String fileName;
    public int btype;
    public String pubDate;

    public enum MessageStatus{
        NORMAL,SENDING,ERROR
    }
}
