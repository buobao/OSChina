package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;

/**
 * 软件列表
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2015年1月20日 下午3:34:52
 *
 */
@SuppressWarnings("serial")
@Root(name = "software")
@Default(value = DefaultType.FIELD, required = false)
public class SoftwareDec extends Entity {
	private String name;
	private String description;
	private String url;
}
