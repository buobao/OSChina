package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

/**
 * 软件实体类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月23日 下午3:03:25
 * 
 */
@SuppressWarnings("serial")
public class Software extends Entity {

	public String title;
	public String author;
	public int authorId;
	public int recommended;
	public String extensionTitle;
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
