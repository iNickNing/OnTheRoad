<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="top.inick.entity.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Student stu = new Student();
		stu.setName("tom");
		out.print(stu.getName());
	%>
	
	<jsp:useBean id="uu1" class="top.inick.entity.Student"></jsp:useBean>
	<jsp:setProperty property="name" name="uu1" value="ttmm"/>
	<jsp:getProperty property="name" name="uu1"/>
	
	<jsp:forward page="/7.jsp">
		<jsp:param value="111" name="name"/>
	</jsp:forward>
	
</body>
</html>