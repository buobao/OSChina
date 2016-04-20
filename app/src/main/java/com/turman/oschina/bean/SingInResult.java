package com.turman.oschina.bean;

/**
 * 签到返回结果实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月22日 下午1:43:13
 *
 */
public class SingInResult {

	public final static String NODE_MES = "msg";
	public final static String NODE_ERROR = "error";

	public String message;// 成功消息
	public String errorMes;// 错误消息
	public boolean ok;// 是否成功
}
