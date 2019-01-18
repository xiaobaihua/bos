package com.xbh.bos.dao.daoimp;

import com.xbh.bos.dao.StaffDao;
import com.xbh.bos.domain.Staff;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xbh
 * @date 2019年1月17日10:19:44
 * @Description
 */
@Repository
public class StaffDaoimp implements StaffDao {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	private StaffDao getStaffDao() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.getMapper(StaffDao.class);
	}


	public int deleteByid(String id) {

		return 0;
	}

	public int save(Staff record) {
		return getStaffDao().save(record);
	}

	public Staff selectByid(String id) {
		return null;
	}

	public int updateByid(Staff record) {
		return 0;
	}
}
