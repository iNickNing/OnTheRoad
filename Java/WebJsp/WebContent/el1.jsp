<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="top.inick.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	
		Student stu = new Student();	
		stu.setName("TOM");
		stu.setCity(new City());
		out.println("name:" + stu.getName() + "<br/>");
		request.setAttribute("stu", stu);
		request.getRequestDispatcher("/el2.jsp").forward(request, response);
	%>
	
	
	

</body>
</html>