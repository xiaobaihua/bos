package com.xbh.bos.dao.daoimp;

import com.xbh.bos.dao.StaffDao;
import com.xbh.bos.domain.Staff;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xbh
 * @date 2019年1月17日10:19:44
 * @Description
 */
@Repository
public class StaffDaoimp implements StaffDao {
	@Override
	public List<Staff> getRecordListLimit(Integer stack, Integer end) {
		return null;
	}

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public int save(Staff record) {
		return 0;
	}

	@Override
	public Staff selectByid(String id) {
		return null;
	}

	@Override
	public int updateByid(Staff record) {
		return 0;
	}



	@Override
	public Integer getTotal() {
		return null;
	}
}
