package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

/**
 * 举报实体类
 * 
 * @author 火蚁（http://my.oschina.net/LittleDY）
 * @version 1.0
 * @created 2014-02-13
 */
public class Report extends Entity {
    private static final long serialVersionUID = 1L;

    public static final byte TYPE_QUESTION = 0x02;// 问题

    public int objId;//需要举报的id
    public String url;// 举报的链接地址
    public byte objType;// 举报的类型
    public int reason;// 原因
    public String otherReason;// 其他原因
}
