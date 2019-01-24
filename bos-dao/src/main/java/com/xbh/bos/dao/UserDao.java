package com.xbh.bos.dao;

import com.xbh.bos.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author xbh
 * @date 2018年12月30日17:39:51
 * @Description
 */
public interface UserDao extends BaseDao<User>{
	@Override
	int save(User record);

	@Override
	User selectByid(String id);

	@Override
	int updateByid(User record);

	@Override
	List<User> getRecordListLimit(Integer stack, Integer end);

	@Override
	Integer getTotal();

	@Select("select * from user_tab where username=#{arg0} and password=md5(#{arg1})")
	User getUserByUsernameAndPassword(String username, String password);

	@Update("update user_tab set password=md5(#{arg1}) where user_id = #{arg0}")
	Integer updatePasswordById(String userID, String newPassword);
}
 