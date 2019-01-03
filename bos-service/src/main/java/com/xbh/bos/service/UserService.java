package com.xbh.bos.service;

import com.xbh.bos.domain.User;

/**
 * @author xbh
 * @date 2019年1月1日10:49:16
 * @Description
 */
public interface UserService {
	User getUserByUsernameAndPassword(String username, String password);
}
