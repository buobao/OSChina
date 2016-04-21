package com.turman.oschina.bean;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

/**
 * 活动备注选择
 * Created by zhangdeyi on 15/8/19.
 */
@Root(name = "remark")
@Default(value = DefaultType.FIELD, required = false)
public class EventRemark implements Serializable {
    public String remarkTip;
    public RemarksSelet remarkSelect;

    @Root(name = "remarkSelect")
    public static class RemarksSelet implements Serializable {
        @ElementList(required = false)
        public List<String> list;
    }
}
