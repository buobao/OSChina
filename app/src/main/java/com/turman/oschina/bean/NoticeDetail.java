package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Base;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/** 
 * 通知实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月27日 下午2:28:42 
 * 
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class NoticeDetail extends Base {
	@Element(required = false)
	public Result result;
}
