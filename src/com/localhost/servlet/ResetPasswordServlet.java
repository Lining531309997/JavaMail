package com.localhost.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.localhost.service.UserService;
import com.localhost.service.Impl.UserServiceImpl;
import com.localhost.vo.User;

/**
 * Servlet implementation class SetNewPasswordServlet
 */
@WebServlet("/SetNewPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordServlet() {
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
		// 获取前端页面参数
		String userName = request.getParameter("userName");  
        String newPassword = request.getParameter("newPassword");  
        String newPassword2 = request.getParameter("newPassword2");
        
        // 数据校验
        Map<String,String> errors = new HashMap<String, String>();  
        if (newPassword == null || "".equals(newPassword)) {  
            errors.put("newPassword", "新密码不能为空！");  
        }  
          
        if (newPassword2 == null || "".equals(newPassword2)) {  
            errors.put("newPassword2", "确认新密码不能为空！");  
        }  
          
        if (!newPassword.equals(newPassword2)) {  
            errors.put("passwordError", "两次输入的密码不一致！");  
        }  
          
        if (!errors.isEmpty()) {  
            request.setAttribute("errors", errors);  
            request.getRequestDispatcher("/resetPassword.jsp?userName=" + userName).forward(request, response);  
            return;  
        }  
        
		// 封装用户数据
		User user = new User();
		user.setUsername(userName);
		user.setPassword(newPassword);
        
		// 要重置密码
		UserService service = new UserServiceImpl();
		try {
			service.resetPassword(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 页面跳转
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
