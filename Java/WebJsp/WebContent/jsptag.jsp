<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page errorPage="error.jsp" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp基础语法</title>
</head>
<body>
	
	<!-- HTML注释 -->
	<%-- JSP注释 --%>

	<%!
		int num1 = 100;
		public void show() {
			System.out.println("bababab");
		}
	%>
	<%
		int num2 = 100;
		num1++;
		num2++;
		int i = 18;
		//out.println(i);
		show();
	%>
	<%=i %>
	<%=num1 %>
	<%=num2 %>
	${1 + 1}
	
</body>
</html>