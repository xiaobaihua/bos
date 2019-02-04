package com.xbh.bos.dao.daoimp;

import com.xbh.bos.dao.StaffDao;
import com.xbh.bos.domain.Staff;
import org.springframework.stereotype.Repository;

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

	@Override
	public int updateDelTagByid(String id, String deltag) {
		return getMapper().updateDelTagByid(id, deltag);
	}

	/**
	 逻辑删除， 先判断是否删除如果没有删除则 deltag为1
	 * @param record
	 * @return 当已被删除(deltag == 0) 返回0更新失败
	 */


}
