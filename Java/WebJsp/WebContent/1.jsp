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
	
		pageContext.setAttribute("p", "pageContext");
		request.setAttribute("p", "request");
		session.setAttribute("p", "session");
		application.setAttribute("p", "application");
		//pageContext.setAttribute("p", "application", PageContext.APPLICATION_SCOPE);
		//request.getRequestDispatcher("/2.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/2.jsp");
		pageContext.forward("/2.jsp");
	%>

</body>
</html>