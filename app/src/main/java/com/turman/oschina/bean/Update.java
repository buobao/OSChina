package com.turman.oschina.bean;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * 更新实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年11月10日 下午12:56:27
 * 
 */
@SuppressWarnings("serial")
@Root(name = "oschina")
public class Update implements Serializable {
	@Element(required = false)
	public UpdateBean update;

	@Root(name = "update")
	@Default(value = DefaultType.FIELD,required = false)
	public static class UpdateBean implements Serializable {
		public String wp7;
		public String ios;
		public AndroidBean android;
	}

	@Root(name = "android")
	@Default(value = DefaultType.FIELD,required = false)
	public static class AndroidBean implements Serializable {
		public int versionCode;
		public String versionName;
		public String downloadUrl;
		public String updateLog;
		public String coverUpdate;
		public String coverStartDate;
		public String coverEndDate;
		public String coverURL;
	}
}
