package com.xbh.bos.dao;

import java.util.List;

/**
 * @author xbh
 * @date 2019年1月22日16:56:53
 * @Description
 */
public interface BaseDao<T> {

	int save(T record);

	T selectByid(String id);

	int updateByid(T record);

	List<T> getRecordListLimit(Integer stack, Integer end);

	Integer getTotal();
}
