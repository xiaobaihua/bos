package com.xbh.bos.service.serviceimp;

import com.xbh.bos.dao.StaffDao;
import com.xbh.bos.domain.Staff;
import com.xbh.bos.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xbh
 * @date
 * @Description
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDao staffDao;

	public int deleteByid(String id) {
		return 0;
	}

	public int save(Staff record) {
		return staffDao.save(record);
	}

	public Staff selectByid(String id) {
		return null;
	}

	public int updateByid(Staff record) {
		return 0;
	}
}
