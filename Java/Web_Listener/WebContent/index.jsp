<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="top.inick.domain.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
三生三世
<%
	//session.invalidate();
/* 	request.setAttribute("name", "tom");
	request.setAttribute("name", "jsck");
	request.removeAttribute("name"); */
	
	session.setAttribute("user", new User());
%>
</body>
</html>