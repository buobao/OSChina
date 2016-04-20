package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Base;
import com.turman.oschina.bean.base.Notice;

/**
 * 操作结果实体类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月14日 下午2:59:27
 * 
 */
@SuppressWarnings("serial")
public class ResultBean extends Base {

    public Result result;
    public Notice notice;
    public Comment comment;

    //现在pub_message接口返回的是comment对象。
    //@XStreamAlias("message")
    public MessageDetail message;

    public int relation;

    public MessageDetail getMessage() {
        //现在pub_message接口返回的是comment对象。所以要转成message
        message = new MessageDetail();
        if(comment!=null) {
            message.id =comment.id;
            message.portrait =comment.portrait;
            message.author =comment.author;
            message.authorId = comment.id;
            message.content = comment.content;
            message.pubDate = comment.pubDate;
        }
        return message;
    }

}
