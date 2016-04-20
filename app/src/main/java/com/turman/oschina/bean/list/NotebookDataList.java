package com.turman.oschina.bean.list;

import com.turman.oschina.bean.NotebookData;
import com.turman.oschina.bean.base.Entity;

import java.util.ArrayList;
import java.util.List;

public class NotebookDataList extends Entity implements
        ListEntity<NotebookData> {
    private static final long serialVersionUID = 1L;

    public List<NotebookData> list = new ArrayList<NotebookData>();

    @Override
    public List<NotebookData> getList() {
        return list;
    }

}