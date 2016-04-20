package com.turman.oschina.bean;

import java.io.Serializable;

/**
 * 更新实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年11月10日 下午12:56:27
 * 
 */
@SuppressWarnings("serial")
public class Update implements Serializable {

	public UpdateBean update;

	public class UpdateBean implements Serializable {
		public String wp7;
		public String ios;
		public AndroidBean android;
	}

	public class AndroidBean implements Serializable {
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
