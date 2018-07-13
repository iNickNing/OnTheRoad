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
	
		Student stu = (Student)request.getAttribute("stu");
		
		out.println(":" + stu.getCity().getAddress() + "<br/>");
		
		
	%>
	
	${stu}  <%-- ${stu } == pageContext.findAttribute("stu"); --%>
	<br/>
	${stu.name}		<!-- 走的getName(), 属性导航 -->
	<br/>
	${stu.city.address}
</body>
</html>