package com.turman.oschina.bean.base;

import org.simpleframework.xml.Element;

/**
 * Created by dqf on 2016/4/20.
 */
public abstract class Entity extends Base {
    @Element(required = false)
    public int id;
    public String cacheKey;
}
