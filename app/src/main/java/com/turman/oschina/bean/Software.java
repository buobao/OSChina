package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;

/**
 * 软件实体类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月23日 下午3:03:25
 * 
 */
@SuppressWarnings("serial")
@Root(name = "software")
@Default(value = DefaultType.FIELD, required = false)
public class Software extends Entity {

	public String title;
	public String author;
	public int authorid;
	public int recommended;
	public String extensiontitle;
	public String license;
	public String body;
	public String homepage;
	public String document;
	public String download;
	public String logo;
	public String language;
	public String os;
	public String recordtime;
	public String url;
	public int favorite;
	public int tweetCount;
}
