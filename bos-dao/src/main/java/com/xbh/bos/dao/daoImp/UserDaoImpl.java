package com.xbh.bos.dao.daoImp;

import com.xbh.bos.dao.UserDao;
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
public class UserDaoImpl implements UserDao {
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public User getUserByUsernameAndPassword(String username, String password) {
		SqlSession session = sqlSessionFactory.openSession();

		UserDao userDao = session.getMapper(UserDao.class);
		return userDao.getUserByUsernameAndPassword(username, password);
	}
}
