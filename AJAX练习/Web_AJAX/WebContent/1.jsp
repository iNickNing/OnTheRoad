<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJS.js"></script>
</head>
<body>
<script type="text/javascript">
	window.onload = function () {
		//获取对象
		var req = getXMLHttpRequest();
		//4.处理响应结果 一般在open之前写好
		req.onreadystatechange = function () {
			//alert(req.readyState);
			if(req.readyState == 4) {
				//alert(req.status);
				if(req.status == 200) {
					alert(req.responseText);
				}
			}
		}
		//建立连接
		req.open("get","${pageContext.request.contextPath}/ServletDemo01");//建立连接
		//发送请求
		req.send(null);
	}
</script>
</body>
</html>