<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 申明一个变量 num -->
	<c:set var="num" value="10" scope="session"></c:set>
	输出变量:<c:out value="${num }"></c:out><br/>
	移除变量:<c:remove var="num" scope="session"/><br/>
	输出变量:<c:out value="${num }"></c:out><br/>
	
	<c:set var="num" value="9" scope="session"></c:set>
	输出变量:<c:out value="${num }"></c:out><br/>
	<c:if test="${5 > 3}">
		aaaaaaa<br/>
	</c:if>
	
	<c:choose>
		<c:when test="${num==1 }">111</c:when>
		<c:when test="${num==3 }">333</c:when>
		<c:when test="${num==9 }">999</c:when>
		<c:otherwise>
			qita
		</c:otherwise>
	</c:choose>
	
	<br/>
	迭代1
	<br/>
	
	<c:forEach var="i" begin="1" end="9" step="1">
		${i } <br/>
	</c:forEach>
	
	<br/>
	迭代2
	<br/>
	<%
		List list = new ArrayList();
		list.add("111111");
		list.add("222222");
		list.add("333333");
		request.setAttribute("list", list);
	%>
	
	<c:forEach items="${list }" var="l">
		${l }
	</c:forEach>
</body>
</html>