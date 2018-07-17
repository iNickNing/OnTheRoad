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
	<form action="">
		用户名:<input type="text" name="username" onblur="ckName()"><span id="msgLable"></span><br/>
		密码:<input type="password" name="password"><br/>
	</form>
	<script type="text/javascript">
		function ckName() {
			//获取用户名
			var name = document.getElementsByTagName("input")[0].value;
			//创建XMLHttpRequest对象
			var xhr = getXMLHttpRequest();
			//设置处理结果
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4) {	//请求完毕
					if(xhr.status == 200) {	//获取服务器状态,200表示正常
						//alert(xhr.responseText);
						var msg = document.getElementById("msgLable");
						if(xhr.responseText == "true") {
							msg.innerHTML = "<font color='red'>用户名已存在</font>";
						} else {
							msg.innerHTML = "用户名可以使用";
						}
					}
				}
			}
			//创建连接
			xhr.open("get", "${pageContext.request.contextPath}/CkNameServlet?name=" + name);
			//发送请求
			xhr.send(null);

		}
	</script>
</body>
</html>