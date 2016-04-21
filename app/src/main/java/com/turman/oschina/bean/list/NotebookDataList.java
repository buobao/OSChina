package com.turman.oschina.bean.list;

import com.turman.oschina.bean.NotebookData;
import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "oschina")
public class NotebookDataList extends Entity implements
        ListEntity<NotebookData> {
    private static final long serialVersionUID = 1L;
    @ElementList(required = false)
    public List<NotebookData> stickies = new ArrayList<NotebookData>();

    @Override
    public List<NotebookData> getList() {
        return stickies;
    }

}