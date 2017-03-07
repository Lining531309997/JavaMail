package com.localhost.service;

import java.sql.SQLException;

import com.localhost.vo.User;

public interface UserService {

	/**
	 * 用户注册
	 * @param user
	 */
	void regist(User user) throws SQLException;
	
	/**
	 * 根据激活码查询用户
	 * @param code 激活码
	 * @return 用户信息
	 */
	User getUserByCode(String code) throws SQLException;

	/**
	 * 更新用户信息
	 * @param user 用户信息
	 */
	void update(User user) throws SQLException;

	/**
	 * 找回用户密码
	 * @param user
	 */
	User findPassword(User user) throws SQLException;

	/**
	 * 重置密码
	 * @param user
	 */
	void resetPassword(User user) throws SQLException;
}
