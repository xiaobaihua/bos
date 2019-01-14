package com.xbh.bos.dao.daoimp;

import com.xbh.bos.dao.UserDao;
import com.xbh.bos.domain.Subarea;
import com.xbh.bos.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xbh
 * @date
 * @Description
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDaoimpl implements UserDao {
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	private UserDao getUserDao(){
		SqlSession session = sqlSessionFactory.openSession();

		return session.getMapper(UserDao.class);
	}

	public Integer deleteByid(String id) {

		return null;
	}

	public Integer insert(Subarea record) {
		return null;
	}

	public User selectByid(String id) {
		return null;
	}

	public int updateByid(Subarea record) {
		return 0;
	}

	public User getUserByUsernameAndPassword(String username, String password) {
		SqlSession session = sqlSessionFactory.openSession();

		return session.getMapper(UserDao.class).getUserByUsernameAndPassword(username, password);
	}

	/**
	 * @param userID
	 * @param newPassword 需要改变的密码
	 * @return 更新条数
	 */
	public Integer updatePasswordById(String userID, String newPassword) {
		SqlSession session = sqlSessionFactory.openSession();

		UserDao userDao = session.getMapper(UserDao.class);
		return userDao.updatePasswordById(userID, newPassword);
	}
}
