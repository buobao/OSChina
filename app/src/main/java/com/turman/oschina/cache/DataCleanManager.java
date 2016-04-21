package com.turman.oschina.cache;

import android.content.Context;
import android.os.Environment;

import java.io.File;

import javax.inject.Inject;

/**
 * 数据删除工具类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月27日 上午10:18:22
 * 
 */
public class DataCleanManager {

	private Context mContext;
	@Inject
	public DataCleanManager(Context context){
		mContext = context;
	}

	/**
	 * 清除本应用内部缓存
	 * (/data/data/com.xxx.xxx/cache)
	 */
	public void cleanInternalCache() {
		deleteFilesByDirectory(mContext.getCacheDir());
		deleteFilesByDirectory(mContext.getFilesDir());
	}

	/**
	 * 清楚本应用所有数据库
	 * (/data/data/com.xxx.xxx/databases)
	 */
	public void cleanDatabases() {
		deleteFilesByDirectory(new File("/data/data/"
				+ mContext.getPackageName() + "/databases"));
	}

	/**
	 * 清除本应用SharedPreference
	 * (/data/data/com.xxx.xxx/shared_prefs)
	 */
	public void cleanSharedPreference() {
		deleteFilesByDirectory(new File("/data/data/"
				+ mContext.getPackageName() + "/shared_prefs"));
	}
	
	/**
	 * 按名字清除本应用数据库
	 * @param dbName
	 */
	public void cleanDatabaseByName(String dbName) {
		mContext.deleteDatabase(dbName);
	}

	/**
	 * 清除/data/data/com.xxx.xxx/files下的内容
	 */
	public void cleanFiles() {
		deleteFilesByDirectory(mContext.getFilesDir());
	}

	/**
	 * 清除外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/cache)
	 */
	public void cleanExternalCache() {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			deleteFilesByDirectory(mContext.getExternalCacheDir());
		}
	}

	/**
	 * 清除自定义路径下的文件，使用需小心，请不要误删。而且只支持目录下的文件删除
	 * @param filePath
	 */
	public void cleanCustomCache(String filePath) {
		deleteFilesByDirectory(new File(filePath));
	}
	
	/**
	 * 清除自定义路径下的文件，使用需小心，请不要误删。而且只支持目录下的文件删除
	 * @param file
	 */
	public void cleanCustomCache(File file) {
		deleteFilesByDirectory(file);
	}

	/**
	 * 清除本应用所有的数据
	 * @param filepath
	 */
	public void cleanApplicationData(String... filepath) {
		cleanInternalCache();
		cleanExternalCache();
		cleanDatabases();
		cleanSharedPreference();
		cleanFiles();
		for (String filePath : filepath) {
			cleanCustomCache(filePath);
		}
	}

	/**
	 * 删除方法 这里只会删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理 
	 * @param directory
	 */
	private void deleteFilesByDirectory(File directory) {
		if (directory != null && directory.exists() && directory.isDirectory()) {
			for (File child : directory.listFiles()) {
				if (child.isDirectory()) {
					deleteFilesByDirectory(child);
				} 
				child.delete();
			}
		}
	}
}
