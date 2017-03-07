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
 * Servlet implementation class FindPasswordServlet
 */
@WebServlet("/FindPasswordServlet")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPasswordServlet() {
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
			// 获取前端参数
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			
			// 封装用户数据
			User user = new User();
			user.setUsername(username);
			user.setEmail(email);
			String code = MD5Util.ccMD5(email) + UUIDUtil.getUUID();
			user.setCode(code);
			
			// 调用找回密码方法
			UserService service = new UserServiceImpl();
			user = service.findPassword(user);
			
			// 页面跳转
			if (user != null) {
				request.setAttribute("msg", "请前往邮箱验证！");
			} else {
				request.setAttribute("msg", "信息有误");
			}
			request.getRequestDispatcher("/result.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
