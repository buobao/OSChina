package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Base;
import com.turman.oschina.bean.base.Notice;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

/**
 * 操作结果实体类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月14日 下午2:59:27
 * 
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class ResultBean extends Base {
    @Element(required = false)
    public Result result;
    @Element(required = false)
    public Notice notice;
    @Element(required = false)
    public Comment comment;

    //现在pub_message接口返回的是comment对象。
    @Transient
    public MessageDetail message;
    @Element(required = false)
    public int relation;

    public MessageDetail getMessage() {
        //现在pub_message接口返回的是comment对象。所以要转成message
        message = new MessageDetail();
        if(comment!=null) {
            message.id =comment.id;
            message.portrait =comment.portrait;
            message.author =comment.author;
            message.authorid = comment.id;
            message.content = comment.content;
            message.pubDate = comment.pubDate;
        }
        return message;
    }

}
