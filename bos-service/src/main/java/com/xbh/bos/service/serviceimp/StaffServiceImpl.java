package com.xbh.bos.service.serviceimp;

import com.xbh.bos.dao.StaffDao;
import com.xbh.bos.dao.daoimp.BaseDaoimp;
import com.xbh.bos.domain.Staff;
import com.xbh.bos.domain.vo.PageVO;
import com.xbh.bos.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xbh
 * @date
 * @Description
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StaffServiceImpl implements StaffService{
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

		List<Staff> list = staffDao.getRecordListLimit(pageVO.getLimitStratIndex(), pageVO.getCurrentRowsTotal());
		Integer total = staffDao.getTotal();

		pageVO.setrows(list);
		pageVO.setTotal(Long.valueOf(total));
		return pageVO;
	}

	@Override
	public Boolean deleteALLByList(List list) {
		// 更新成功条数
		int totle = 0;

		for (Object o : list) {
			String deltagByid = staffDao.getDeltagByid(o.toString());

			if (Integer.valueOf(deltagByid) != 1){
				totle += staffDao.updateDelTagByid(o.toString(), "1");
			}
		}
		return totle != 0;
	}

	@Override
	public Boolean restoreAllByList(List list) {
		// 更新成功条数
		int totle = 0;
		for (Object o : list) {
			String deltagByid = staffDao.getDeltagByid(o.toString());
			if (Integer.valueOf(deltagByid) != 0){
				totle += staffDao.updateDelTagByid(o.toString(), "0");
			}
		}
		return totle != 0;
	}

	@Override
	public Set queryStaffByTelORNameORStation(Staff staff) {
		Set result = new HashSet() {
		};
		if (staff.getName() != null && staff.getName() != "" ){
			result.addAll(staffDao.getStaffByName(staff.getName()));
		}

		if (staff.getName() != null && staff.getName() != "") {
			result.addAll(staffDao.getStaffByStation(staff.getStation()));
		}

		if (staff.getName() != null && staff.getName() != "") {
			result.addAll(staffDao.getStaffByName(staff.getName()));
		}
		return result;
	}

	@Override
	public int save(Staff record) {
		return staffDao.save(record);
	}

	@Override
	public int deleteByID(String id) {
		return 0;
	}

	@Override
	public int updateByID(Staff record) {
		return staffDao.updateByid(record);
	}

	@Override
	public Staff findByID(String id) {
		return null;
	}
}
