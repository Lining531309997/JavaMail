package com.localhost.service.Impl;

import java.sql.SQLException;

import com.localhost.dao.UserDao;
import com.localhost.dao.Impl.UserDaoImpl;
import com.localhost.service.UserService;
import com.localhost.util.MailUtil;
import com.localhost.vo.User;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public void regist(User user) throws SQLException {
		// 存入数据库
		userDao.regist(user);
		// 发送激活邮件
		MailUtil.sendMail(user.getEmail(), user.getCode());
	}

	@Override
	public User getUserByCode(String code) throws SQLException {
		// 根据激活码查询用户
		return userDao.getUserByCode(code);
	}

	@Override
	public void update(User user) throws SQLException {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	public User findPassword(User user) throws SQLException {
		// 查询用户信息
		User resultUser = userDao.findPassword(user);
		
		if (resultUser != null) {
			// 将验证码存入数据库
			userDao.setCheckCode(resultUser.getId(),user.getCode());
			// 发送验证码到用户邮箱
			MailUtil.findPasswordMail(user.getEmail(), user.getCode());
		}
		return resultUser;
	}

	@Override
	public void resetPassword(User user) throws SQLException {
		// 重置密码
		userDao.resetPassword(user);
	}

}
