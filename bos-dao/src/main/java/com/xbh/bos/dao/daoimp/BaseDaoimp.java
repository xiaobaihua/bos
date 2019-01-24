package com.xbh.bos.dao.daoimp;

import com.xbh.bos.dao.BaseDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Logger;


/**
 * @author xbh
 * @date 2019年1月22日16:56:23
 * @Description
 */
@Repository
public class BaseDaoimp<T> implements BaseDao<T> {
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	Class clazz;
	/**
	 * 子类实现的dao接口
	 */
	Class interf;

	/**
	 * 通过构造方法， 自动获取子类的mapper接口与泛型
	 */
	public BaseDaoimp() {
		try {
			ParameterizedType type = ((ParameterizedType) this.getClass().getGenericSuperclass());
			this.clazz = (Class)type.getActualTypeArguments()[0];
			this.interf = this.getClass().getInterfaces()[0];
		}catch (ClassCastException e){
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.info("Type强转parameterType异常");
		}

	}

	protected BaseDao getMapper(){
		SqlSession session = sqlSessionFactory.openSession();
		return (BaseDao) session.getMapper(this.interf);
	}

	@Override
	public int save(T record) {
		return getMapper().save(record);
	}

	@Override
	public T selectByid(String id) {
		return (T)(getMapper().selectByid(id));
	}

	@Override
	public int updateByid(T record) {
		return getMapper().updateByid(record);

	}

	@Override
	public List<T> getRecordListLimit(Integer stack, Integer end) {
		return getMapper().getRecordListLimit(stack, end);
	}

	@Override
	public Integer getTotal() {
		return getMapper().getTotal();
	}
}
