package com.xbh.bos.service.serviceimp;

import com.xbh.bos.dao.UserDao;
import com.xbh.bos.service.UserService;
import com.xbh.bos.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author xbh
 * @date
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public User getUserByUsernameAndPassword(String username, String password){
		return userDao.getUserByUsernameAndPassword(username, password);
	}

	public Integer updatePasswordById(String userID, String newPassword) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		// 用户ID存在
		if (StringUtils.isExist(userID)){
			return userDao.updatePasswordById(userID, newPassword);
		}
		// 0为失败
		return 0;
	}
}
