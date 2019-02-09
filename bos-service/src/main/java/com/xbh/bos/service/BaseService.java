package com.xbh.bos.service;

/**
 * @author xbh
 * @date 2019年1月17日10:46:58
 * @Description 实现了基本增删改查
 */
public interface BaseService<T> {
	/**
	 向数据库添加
	 * @param record
	 * @return 0为更新失败
	 */
	int save(T record);

	/**
	 根据id删除实体
	 * @param id
	 * @return 0为删除失败
	 */
	int deleteByID(String id);

	/**
	 更新该实体
	 * @param record
	 * @return 0为更新失败
	 */
	int updateByID(T record);

	/**
	 查找实体
	 * @param id
	 * @return 返回id所属的实体， null为失败
	 */
	T findByID(String id);
}
