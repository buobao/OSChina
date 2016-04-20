package com.turman.oschina.bean;

import com.turman.oschina.bean.base.Entity;

import java.io.Serializable;

/**
 * 二维码扫描实体类
 * @author 火蚁 (http://my.oschina.net/LittleDY)
 * @version 1.0
 * @created 2014-3-17
 */
@SuppressWarnings("serial")
public class BarCode extends Entity implements Serializable{
	
	public final static String NODE_REQURE_LOGIN = "require_login";
	public final static String NODE_TYPE = "type"; 
	public final static String NODE_URL = "url";
	public final static String NODE_TITLE = "title";
	
	public final static byte LOGIN_IN = 0x00;// 登录
	public final static byte SIGN_IN = 0x01;// 签到

	public boolean requireLogin;// 是否需要登录
	public int type;// 类型
	public String url;// url地址
	public String title;// 标题
	
	@Override
	public String toString() {
		return "Barcode [requireLogin=" + requireLogin + ", type=" + type
				+ ", url=" + url + "]";
	}
}
