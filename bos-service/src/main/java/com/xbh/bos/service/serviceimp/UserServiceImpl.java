package com.xbh.bos.service.serviceimp;

import com.xbh.bos.dao.UserDao;
import com.xbh.bos.domain.User;
import com.xbh.bos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xbh
 * @date
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public User getUserByUsernameAndPassword(String username, String password) {
		return userDao.getUserByUsernameAndPassword(username, password);
	}
}
