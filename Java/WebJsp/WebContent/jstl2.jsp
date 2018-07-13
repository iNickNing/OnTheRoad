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

	<%
		List list = new ArrayList();
		list.add("111111");
		list.add("222222");
		list.add("333333");
		list.add("444444");
		list.add("555555");
		request.setAttribute("list", list);
	%>

	<table border="1" cellspacing="0">
		<tr>
			<th>数据</th>
			<th>索引</th>
			<th>计数</th>
			<th>第一个</th>
			<th>最后一个</th>
		</tr>
		
		<c:forEach items="${list }" var="l" varStatus="vs">
			<tr ${vs.count%2 == 0 ? "style='background-color:lime'" : "background:blue;" }>
			<!-- <tr style="text-align:center;background:blue;"> -->
				<td>${l }</td>
				<td>${vs.index }</td>
				<td>${vs.count }</td>
				<td>${vs.first }</td>
				<td>${vs.last }</td>
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>