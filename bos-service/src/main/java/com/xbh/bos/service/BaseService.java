package com.xbh.bos.service;

/**
 * @author xbh
 * @date 2019年1月17日10:46:58
 * @Description 实现了基本增删改查
 */
public interface BaseService<E> {
	int deleteByid(String id);

	int save(E record);

	E selectByid(String id);

	int updateByid(E record);
}
