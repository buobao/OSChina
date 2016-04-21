package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * 便签数据bean（有重载equals()方法）
 * 
 * @author kymjs (https://github.com/kymjs)
 * 
 */
@Root(name = "sticky")
public class NotebookData extends Entity implements Serializable,
        Comparable<NotebookData> {
    private static final long serialVersionUID = 1L;

    @Element(required = false)
    public int iid;
    @Element(required = false)
    public String timestamp;
    @Element(required = false)
    public String updateTime;
    @Element(required = false)
    public String content;
    @Element(required = false)
    public String color;

    public String serverUpdateTime; // 服务器端需要，客户端无用,和unixTime一同设置
    public int resultcolor;

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            return true;
        } else {
            if (o instanceof NotebookData) {
                NotebookData data = (NotebookData) o;
                try {
                    return (this.id == data.id)
                            && (this.iid == data.iid)
                            && (this.timestamp == data.timestamp
                            && (this.updateTime.equals(data.updateTime))
                            && (this.content == data.content)
                            && (this.resultcolor == data.getColor()));
                } catch (NullPointerException e) {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public void setUnixTime(String time) {
        this.timestamp = time;
        serverUpdateTime = time;
    }


    public int getColor() {
        // 客户端始终以当前手机上的颜色为准
        if ("blue".equals(color)) {
            this.resultcolor = 3;
        } else if ("red".equals(color)) {
            this.resultcolor = 2;
        } else if ("yellow".equals(color)) {
            this.resultcolor = 1;
        } else if ("purple".equals(color)) {
            this.resultcolor = 4;
        } else if ("green".equals(color)) {
            this.resultcolor = 0;
        }
        return resultcolor;
    }

    public void setColor(int color) {
        switch (color) {
        case 0:
            this.color = "green";
            break;
        case 1:
            this.color = "yellow";
            break;
        case 2:
            this.color = "red";
            break;
        case 3:
            this.color = "blue";
            break;
        case 4:
            this.color = "purple";
            break;
        default:
            this.resultcolor = color;
            break;
        }
    }

    @Override
    public int compareTo(NotebookData another) {
        return this.iid - another.iid;
    }
}