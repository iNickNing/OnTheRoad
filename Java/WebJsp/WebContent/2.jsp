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
	
		String p = (String) pageContext.getAttribute("p");
		String p2 = (String) request.getAttribute("p");
		String p3 = (String) session.getAttribute("p");
		String p4 = (String) application.getAttribute("p");
		out.println("pageContext:p=" + p + "<br/>");
		out.println("request:p=" + p2 + "<br/>");
		out.println("session:p=" + p3 + "<br/>");
		out.println("application:p=" + p4 + "<br/>");
	%>
	
	${applicationScope.p } <br/>

</body>
</html>