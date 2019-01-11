package com.xbh.bos.utils;

/**
 * @author xbh
 * @date 2019年1月10日11:52:09
 * @Description
 */
public class StringUtils {

	/**
	 * @param s
	 * @return 存在返回True， 不存在放回false
	 */
	static public boolean isExist(String s){
		return !(s == null || s.equals(""));
	}
}
