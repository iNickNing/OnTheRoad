<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form>
		<input type="text" name="username" />
	</form>
	
	<%
		Date date = new Date();
		out.write(date.toLocaleString());
	%>
	
	<%
	
		//String name = request.getParameter("username");
		//String name = (String)request.getSession().getAttribute("username");
		String name = (String)session.getAttribute("username");
		out.write("欢迎您:" + name);
	
	%>
	<p>这里是主页</p>
</body>
</html>