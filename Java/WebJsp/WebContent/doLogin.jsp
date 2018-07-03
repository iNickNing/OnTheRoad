<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	
		//获取表单数据
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		//处理业务逻辑
		if("tom".equals(username) && "123".equals(pwd)) {
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		} else {
			response.sendRedirect("/WebJsp/login.jsp");
		}
		//分发转向
	
	%>
