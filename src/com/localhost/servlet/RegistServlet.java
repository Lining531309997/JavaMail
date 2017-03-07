package com.localhost.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.localhost.service.UserService;
import com.localhost.service.Impl.UserServiceImpl;
import com.localhost.util.MD5Util;
import com.localhost.util.UUIDUtil;
import com.localhost.vo.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 获取参数
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			// 封装数据
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setState(0);
			String code = MD5Util.ccMD5(email) + UUIDUtil.getUUID();
			user.setCode(code);
			// 调用业务层处理数据
			UserService service = new UserServiceImpl();
			service.regist(user);
			// 页面跳转
			request.setAttribute("msg", "您已经注册成功请前往邮箱激活！");
			request.getRequestDispatcher("/result.jsp").forward(request, response);
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
