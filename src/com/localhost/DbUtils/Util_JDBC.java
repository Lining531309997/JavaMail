package com.localhost.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util_JDBC {

	/**
	 * 参数需要读取配置文件获取
	 */
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/ytj?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	/**
	 * 工具类的构造方法一般都是私有的。因为工具类中的方法都是静态的，不需要new对象
	 */
	public Util_JDBC() {}
	
	/**
	 * 获取数据库连接对象
	 * @return 数据库连接
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return con;
	}

	/**
	 * 开启事务
	 * @param con 数据库连接对象
	 * @throws SQLException
	 */
	public static void beginTransaction(Connection con) throws SQLException {
		if (con != null) {
			con.setAutoCommit(false);
		}
	}
	
	/**
	 * 提交事务
	 * @param con 数据库连接对象
	 * @throws SQLException
	 */
	public static void commitTransaction(Connection con) throws SQLException {
		if (con != null) {
			con.commit();
		}
	}
	
	/**
	 * 回滚事务
	 * @param con 数据库连接对象
	 */
	public static void rollbackTransaction(Connection con) {
		if (con != null) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭数据库连接
	 * @param con 数据库连接
	 * @param ps 预编译语句
	 * @param res 结果集
	 */
	public static void close(Connection con, PreparedStatement ps, ResultSet res) {
		if (res != null) {
			try {
				res.close();
				res = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
				ps = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
