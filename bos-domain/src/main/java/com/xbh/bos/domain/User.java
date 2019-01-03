package com.xbh.bos.domain;

import java.io.Serializable;

/**
 * @author xbh
 * @date 2018年12月30日16:55:26
 * @Description
 */
public class User implements Serializable {
	private static final long serialVersionUID = 7828377356325252552L;
	private String user_id;
	private String username;
	private String password;


	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
