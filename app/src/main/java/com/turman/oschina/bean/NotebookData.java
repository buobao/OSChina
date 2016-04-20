package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import java.io.Serializable;

/**
 * 便签数据bean（有重载equals()方法）
 * 
 * @author kymjs (https://github.com/kymjs)
 * 
 */
public class NotebookData extends Entity implements Serializable,
        Comparable<NotebookData> {
    private static final long serialVersionUID = 1L;

    public int id;
    public int iid;
    public String unixTime;
    public String date;
    public String content;
    public String colorText;

    public String serverUpdateTime; // 服务器端需要，客户端无用,和unixTime一同设置
    public int color;

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
                            && (this.unixTime == data.unixTime
                            && (this.date.equals(data.date))
                            && (this.content == data.content)
                            && (this.color == data.getColor()));
                } catch (NullPointerException e) {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public void setUnixTime(String time) {
        this.unixTime = time;
        serverUpdateTime = time;
    }


    public int getColor() {
        // 客户端始终以当前手机上的颜色为准
        if ("blue".equals(colorText)) {
            this.color = 3;
        } else if ("red".equals(colorText)) {
            this.color = 2;
        } else if ("yellow".equals(colorText)) {
            this.color = 1;
        } else if ("purple".equals(colorText)) {
            this.color = 4;
        } else if ("green".equals(colorText)) {
            this.color = 0;
        }
        return color;
    }

    public void setColor(int color) {
        switch (color) {
        case 0:
            colorText = "green";
            break;
        case 1:
            colorText = "yellow";
            break;
        case 2:
            colorText = "red";
            break;
        case 3:
            colorText = "blue";
            break;
        case 4:
            colorText = "purple";
            break;
        default:
            this.color = color;
            break;
        }
    }

    @Override
    public int compareTo(NotebookData another) {
        return this.iid - another.iid;
    }
}