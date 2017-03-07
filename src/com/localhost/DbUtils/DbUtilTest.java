package com.localhost.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DbUtilTest {

	public static void main(String[] args) {
//		User user = new User();
//		user.setUsername("DbUtils");
//		user.setPassword("123");
//		user.setNickname("JDBC");
//		insert(user);
		query();
	}

	/**
	 * 插入用户信息
	 * @param user 新增的用户信息
	 */
	public static void insert(User user) {
		System.out.println("----------- Test Insert ----------");
		// 创建连接
		Connection connection = Util_JDBC.getConnection();
		// 创建SQL执行工具
		QueryRunner runner = new QueryRunner();
		// 创建SQL语句
		String sql = "INSERT INTO base_user(username,password,nickname,gender,birthday,email,mobile,qq,address,post_code,is_delete,logo_path) VALUES (?,?,?,?,?,?,?,?,?,?,0,?)";
		// 创建参数数组
		Object[] params = {user.getUsername(),user.getPassword(),user.getNickname(),user.getGender(),user.getBirthday(),user.getEmail(),user.getMobile(),user.getQq(),user.getAddress(),user.getPost_code(),user.getLogo_path()};
		// 执行SQL语句
		try {
			runner.update(connection, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(connection);
		}
	}
	
	public static void query() {
		System.out.println("----------- Test Insert ----------");
		// 创建连接
		Connection connection = Util_JDBC.getConnection();
		// 创建SQL执行工具
		QueryRunner runner = new QueryRunner();
		// 创建SQL语句
		String sql = "SELECT * FROM base_user";
		// 执行SQL语句
		try {
			List<User> userList = (List<User>) runner.query(connection, sql, new BeanListHandler(User.class));
			
			for (User user : userList) {
				System.out.println(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(connection);
		}
	}
	
}
