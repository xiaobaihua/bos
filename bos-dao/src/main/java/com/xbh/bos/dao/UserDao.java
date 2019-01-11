package com.xbh.bos.dao;

import com.xbh.bos.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author xbh
 * @date 2018年12月30日17:39:51
 * @Description
 */
public interface UserDao {

	/**
	*@author xbh
	*@date 2019/1/1 11:31
	*@param username
	*@param password
	*@return com.xbh.bos.domain.User
	*@description
	*/
	@Select("select * from user_tab where username=#{arg0} and password=md5(#{arg1})")
	User getUserByUsernameAndPassword(String username, String password);

	@Update("update user_tab set password=md5(#{arg1}) where user_id = #{arg0}")
	Integer updatePasswordById(String userID, String newPassword);
}
 