package com.turman.oschina.bean.list;

import com.turman.oschina.bean.base.Entity;

import java.io.Serializable;
import java.util.List;

public interface ListEntity<T extends Entity> extends Serializable {

    public List<T> getList();
}
