<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Structs 2 入门</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<%-- 在Structs2中,控制器会默认拦截扩展名为.action的请求, 除此之外,什么都不写也可以 --%>
    <a href="${pageContext.request.contextPath }/hello.action">点击我.action</a>
    <a href="${pageContext.request.contextPath }/hello">再点击我</a>
    <a href="${pageContext.request.contextPath }/hello.do">点击我.do</a>
    <a href="${pageContext.request.contextPath }/hello.abc">点击我.abc</a>
    <a href="${pageContext.request.contextPath }/hello.abcd">点击我.abcd</a>
    <br/>
    <br/>
    <a href="${pageContext.request.contextPath }/world.action">点击我.action</a>
    <a href="${pageContext.request.contextPath }/world">再点击我</a>
    <a href="${pageContext.request.contextPath }/world.do">点击我.do</a>
    <br/>
    <br/>
            用户管理
    <a href="${pageContext.request.contextPath }/addUser.action">添加用户.action</a>
    <a href="${pageContext.request.contextPath }/deleteUser.action">删除用户.action</a>
    <a href="${pageContext.request.contextPath }/updateUser.action">更新用户.action</a>
    <a href="${pageContext.request.contextPath }/findUser.action">查询用户.action</a>
    <br/>
    <br/>
            用户管理(动态方法调用)
            <%-- 
            	动态方法调用
            		动作名称!动作方法名称
            		动作名称!动作方法名称.action
            	
             --%>
    <a href="${pageContext.request.contextPath }/user!addUser.action">添加用户.action</a>
    <a href="${pageContext.request.contextPath }/user!deleteUser.action">删除用户.action</a>
    <a href="${pageContext.request.contextPath }/user!updateUser.action">更新用户.action</a>
    <a href="${pageContext.request.contextPath }/user!findUser.action">查询用户.action</a>
    
  </body>
</html>
