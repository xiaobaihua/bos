package com.xbh.bos.dao;

import com.xbh.bos.domain.Subarea;
import com.xbh.bos.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author xbh
 * @date 2018年12月30日17:39:51
 * @Description
 */
public interface UserDao {
	Integer deleteByid(String id);

	Integer insert(Subarea record);

	User selectByid(String id);

	int updateByid(Subarea record);

	@Select("select * from user_tab where username=#{arg0} and password=md5(#{arg1})")
	User getUserByUsernameAndPassword(String username, String password);

	@Update("update user_tab set password=md5(#{arg1}) where user_id = #{arg0}")
	Integer updatePasswordById(String userID, String newPassword);
}
 