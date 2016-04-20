package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

/**
 * 聊天详细信息实体类
 * @author 铂金小鸟（http://my.oschina.net/fants）
 * @Created 2015年9月16日 上午4:20:01
 */
@SuppressWarnings("serial")
public class MessageDetail extends Entity {

    //是否显示时间
    public boolean showDate;
    //消息状态
    public MessageStatus status;
    public String portrait;
    public String author;
    public int authorId;
    public String content;
    public String fileName;
    public int btype;
    public String pubDate;

    public enum MessageStatus{
        NORMAL,SENDING,ERROR
    }
}
