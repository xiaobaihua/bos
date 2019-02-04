package com.xbh.bos.service;

import com.xbh.bos.domain.Staff;
import com.xbh.bos.domain.vo.PageVO;

import java.util.List;

/**
 * @author xbh
 * @date 2019年1月17日10:46:02
 * @Description
 */
public interface StaffService extends BaseService<Staff>{
	PageVO getStaffList(String page, String rows);

	Boolean deleteALLByList(List list);

	Boolean restoreAllByList(List list);
}
