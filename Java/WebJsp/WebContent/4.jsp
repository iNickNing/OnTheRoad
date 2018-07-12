<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	aaaaaaaaaaaaaaaaaaaaaaa
	<%@ include file="/5.jsp" %>
	
	<%-- <jsp:include page="/5.jsp"></jsp:include> --%>
	
	<%
		
		if(5 > 3) {
			out.print(5);
		}
	
	%>
	
	<c:if test="${5 > 3}">
		ccccccccccc
	</c:if>
	
</body>
</html>