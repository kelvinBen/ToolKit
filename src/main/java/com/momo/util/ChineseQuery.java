package com.momo.util;

public class ChineseQuery {
	
	/**
	 * 是否包含中文
	 * 
	 * @param s 需要判断的字符串
	 * @return true 或者 false
	 */
	public static boolean containsChinese(String s) {
		if (null == s || "".equals(s.trim()))
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (isChinese(s.charAt(i)))
				return true;
		}
		return false;
	}
	
	/**
	 * 判断是否为中文
	 * 
	 * @param a 需要判断的单个字符
	 * @return true 或者 false
	 */
	public static boolean isChinese(char a) {
		int v = (int) a;
		return (v >= 19968 && v <= 38191);
	}
	
	
}
