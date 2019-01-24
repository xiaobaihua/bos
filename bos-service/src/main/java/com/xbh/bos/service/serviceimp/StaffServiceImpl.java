package com.xbh.bos.service.serviceimp;

import com.xbh.bos.dao.StaffDao;
import com.xbh.bos.domain.Staff;
import com.xbh.bos.domain.vo.PageVO;
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

	/**
	 * @param page 当前页面
	 * @param rows 当前页面条数
	 * @return 封装好的pageVO
	 */
	@Override
	public PageVO getStaffList(String page, String rows) {
		PageVO pageVO = new PageVO();
		pageVO.setCurrentPage(Integer.valueOf(page));
		pageVO.setCurrentRowsTotal(Integer.valueOf(rows));

		staffDao.getRecordListLimit(pageVO.getLimitStratIndex(), pageVO.getLimitEndIndex());

		return pageVO;
	}

	@Override
	public int save(Staff staff) {
		return 0;
	}
}
