package com.xbh.bos.service;

import com.xbh.bos.domain.User;
import org.apache.ibatis.annotations.Select;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author xbh
 * @date 2019年1月1日10:49:16
 * @Description
 */
public interface UserService extends BaseService<User> {
	User getUserByUsernameAndPassword(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;

	Integer updatePasswordById(String userID, String newPassword) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
