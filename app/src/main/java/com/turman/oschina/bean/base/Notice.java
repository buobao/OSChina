package com.turman.oschina.bean.base;

import java.io.Serializable;

/**
 * 通知信息实体类
 * Created by dqf on 2016/4/20.
 */
public class Notice implements Serializable {
    public final static String UTF8 = "UTF-8";
    public final static String NODE_ROOT = "oschina";

    public final static int TYPE_ATME = 1;
    public final static int TYPE_MESSAGE = 2;
    public final static int TYPE_COMMENT = 3;
    public final static int TYPE_NEWFAN = 4;
    public final static int TYPE_NEWLIKE = 5;

    public int atmeCount;
    public int msgCount;
    public int reviewCount;
    public int newFansCount;
    public int newLikeCount;
}









































