<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
		String name = request.getParameter("username");
		out.write("欢迎您:" + name);
	
	%>
	<br/>
	${username } 这是从Attribute中取的
	<br/>
	${param.username } 这是从Parameter中取的
	<br/>
	${header["User-agent"] }
	<br/>
	${cookie.JSESSIONID.value }
	<br/>
	<a href="/WebJsp/index.jsp">返回主页</a>
</body>
</html>