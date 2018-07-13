<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"  + request.getServerName() + ":" + request.getServerPort() + path + "/";
			

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ empty u }">
		<a href="login.jsp">登录</a>
		<a href="reg.jsp">注册</a>
	</c:if>
	<c:if test="${ not empty u }">
		欢迎您:${u.username }	
		<a href="${pageContext.request.contextPath }/servlet/logoutServlet">注销</a>
		
	</c:if>
</body>
</html>