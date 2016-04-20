package com.turman.oschina.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 活动备注选择
 * Created by zhangdeyi on 15/8/19.
 */
public class EventRemark implements Serializable {
    public String remarkTip;
    public RemarksSelet select;

    public class RemarksSelet implements Serializable {
        public List<String> list;
    }
}
