package com.xbh.bos.service.serviceimp;

import com.xbh.bos.dao.StaffDao;
import com.xbh.bos.domain.Staff;
import com.xbh.bos.domain.vo.PageVO;
import com.xbh.bos.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

	/**
	 * @param page 当前页面
	 * @param rows 当前页面条数
	 * @return 封装好的pageVO
	 */
	public PageVO getStaffList(String page, String rows) {
		PageVO pageVO = new PageVO();
		pageVO.setCurrentPage(Integer.valueOf(page));
		pageVO.setCurrentRowsTotal(Integer.valueOf(rows));


		return pageVO;
	}
}
