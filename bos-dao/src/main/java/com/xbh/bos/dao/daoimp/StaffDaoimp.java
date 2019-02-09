package com.xbh.bos.dao.daoimp;

import com.xbh.bos.dao.StaffDao;
import com.xbh.bos.domain.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xbh
 * @date 2019年1月17日10:19:44
 * @Description
 */
@Repository
public class StaffDaoimp extends BaseDaoimp<Staff> implements StaffDao{

	@Override
	protected StaffDao getMapper() {
		return (StaffDao)super.getMapper();
	}

	@Override
	public String getDeltagByid(String id) {
		return getMapper().getDeltagByid(id);
	}
	/**
	 逻辑删除， 先判断是否删除如果没有删除则 deltag为1
	 * @param id, deltag
	 * @param deltag 删除标记
	 * @return 当已被删除(deltag == 0) 返回0更新失败
	 */
	@Override
	public int updateDelTagByid(String id, String deltag) {
		return getMapper().updateDelTagByid(id, deltag);
	}

	@Override
	public List getStaffByTel(String tel) {
		return getMapper().getStaffByTel(tel);
	}

	@Override
	public List getStaffByName(String name) {
		return getMapper().getStaffByName(name);
	}

	@Override
	public List getStaffByStation(String station) {
		return getMapper().getStaffByStation(station);
	}


}
