<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重置密码</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/resetPassword" method="post">  
	    <span class="error" style="display: block;">${errors.passwordError}</span>  
	    用户名：<input type="text" name="userName"/><span class="error">${userName}<br/>  
	    新密码：<input type="password" name="newPassword" /><span class="error">${errors.newPassword}</span><br/>  
	    确认新密码：<input type="password" name="newPassword2"/><span class="error">${errors.newPassword2 }</span><br/>  
	    <input type="submit" value="修改" />  
	</form> 
</body>
</html>