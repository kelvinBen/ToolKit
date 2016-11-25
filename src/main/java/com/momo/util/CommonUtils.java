package com.momo.util;

public class CommonUtils {
	/**
	 * 获取系统名称
	 * 
	 * @return 返回系统名称小写
	 */
	public static String getOsName(){
		return System.getProperty("os.name").toLowerCase();
	}
	
	/**
	 * 设置线程睡眠
	 * 
	 * @param millis 睡眠时间
	 */
	public static void sleep(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
