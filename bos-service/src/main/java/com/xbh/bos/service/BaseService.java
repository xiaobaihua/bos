package com.xbh.bos.service;

/**
 * @author xbh
 * @date 2019年1月17日10:46:58
 * @Description 实现了基本增删改查
 */
public interface BaseService<T> {
	/**
	 * @param record
	 * @return 0为更新失败
	 */
	int save(T record);
}
