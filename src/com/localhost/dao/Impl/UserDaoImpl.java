package com.localhost.dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.localhost.c3p0.C3P0DBUtil;
import com.localhost.dao.UserDao;
import com.localhost.vo.User;

public class UserDaoImpl implements UserDao {
	
	@Override
	public void regist(User user) throws SQLException {
		// 创建缓冲池对象
		C3P0DBUtil pool = C3P0DBUtil.getInstance();
		// 创建连接
		Connection connection = pool.getConnection();
		// 创建SQL执行工具
		QueryRunner runner = new QueryRunner();
		// 创建SQL语句
		String sql = "INSERT INTO user(username,password,email,state,code) VALUES (?,?,?,?,?)";
		// 创建参数数组
		Object[] params = {user.getUsername(),user.getPassword(),user.getEmail(),user.getState(),user.getCode()};
		// 执行SQL语句
		runner.update(connection, sql, params);
	}

	@Override
	public User getUserByCode(String code) throws SQLException {
		// 创建缓冲池对象
		C3P0DBUtil pool = C3P0DBUtil.getInstance();
		// 创建连接
		Connection connection = pool.getConnection();
		// 创建SQL执行工具
		QueryRunner runner = new QueryRunner();
		// 创建SQL语句
		String sql = "SELECT * FROM user WHERE code = ?";
		// 执行SQL语句
		User user = (User) runner.query(connection, sql, new BeanHandler<User>(User.class), code);
		return user;
	}

	@Override
	public void update(User user) throws SQLException {
		// 创建缓冲池对象
		C3P0DBUtil pool = C3P0DBUtil.getInstance();
		// 创建连接
		Connection connection = pool.getConnection();
		// 创建SQL执行工具
		QueryRunner runner = new QueryRunner();
		// 创建SQL语句
		String sql = "UPDATE user SET code = ?, state = ? WHERE id = ?";
		// 创建参数数组
		Object[] params = {user.getCode(),user.getState(),user.getId()};
		// 执行SQL语句
		runner.update(connection, sql, params);
	}

	@Override
	public User findPassword(User user) throws SQLException {
		// 创建缓冲池对象
		C3P0DBUtil pool = C3P0DBUtil.getInstance();
		// 创建连接
		Connection connection = pool.getConnection();
		// 创建SQL执行工具
		QueryRunner runner = new QueryRunner();
		// 创建SQL语句
		String sql = "SELECT id,username,password,email,state,code FROM user WHERE email = ? AND state = 1";
		// 执行SQL语句
		User resultUser = (User) runner.query(connection, sql, new BeanHandler<User>(User.class), user.getEmail());
		return resultUser;
	}

	@Override
	public void setCheckCode(Integer id, String code) throws SQLException {
		// 创建缓冲池对象
		C3P0DBUtil pool = C3P0DBUtil.getInstance();
		// 创建连接
		Connection connection = pool.getConnection();
		// 创建SQL执行工具
		QueryRunner runner = new QueryRunner();
		// 创建SQL语句
		String sql = "UPDATE user SET code = ? WHERE id = ?";
		// 创建参数数组
		Object[] params = {code, id};
		// 执行SQL语句
		runner.update(connection, sql, params);
	}

	@Override
	public void resetPassword(User user) throws SQLException {
		// 创建缓冲池对象
		C3P0DBUtil pool = C3P0DBUtil.getInstance();
		// 创建连接
		Connection connection = pool.getConnection();
		// 创建SQL执行工具
		QueryRunner runner = new QueryRunner();
		// 创建SQL语句
		String sql = "UPDATE user SET password = ? WHERE username = ?";
		// 创建参数数组
		Object[] params = {user.getPassword(), user.getUsername()};
		// 执行SQL语句
		runner.update(connection, sql, params);
	}

}
