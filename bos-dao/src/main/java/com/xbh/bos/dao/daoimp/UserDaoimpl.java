package com.xbh.bos.dao.daoimp;

import com.xbh.bos.dao.UserDao;
import com.xbh.bos.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xbh
 * @date
 * @DescriptionT
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDaoimpl extends BaseDaoimp<User> implements UserDao  {
//	@Override
//	public User getUserByUsernameAndPassword(String username, String password) {
//		return null;
//	}
//
//	@Override
//	public Integer updatePasswordById(String userID, String newPassword) {
//		return null;
//	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		UserDao userDao = (UserDao) super.getMapper();
		return userDao.getUserByUsernameAndPassword(username, password);
	}

	/**
	 * @param userID
	 * @param newPassword 需要改变的密码
	 * @return 更新条数
	 */
	@Override
	public Integer updatePasswordById(String userID, String newPassword) {
		UserDao userDao = (UserDao) super.getMapper();
		return userDao.updatePasswordById(userID, newPassword);
	}
}
