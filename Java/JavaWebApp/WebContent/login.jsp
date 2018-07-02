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
	
		String msg = (String)request.getAttribute("msg");
		if(msg != null) {
			out.print(msg);
		}
	
	%>
	<form action="/JavaWebApp/session/doLogin" method="post">
		用户名:<input type="text" name="username" /><br/>
		密码:<input type="password" name="password" /><br/>
		验证码:<input type="text" name="code" />
		<!-- <img id="captcha" src="/JavaWebApp/servlet2/demo03"/> -->
		<img id="captcha" src="/JavaWebApp/session/code"/>
		<a id="captchaBtn" href="javascript:;">看不清,换一张</a><br/>
		<input type="submit" value="登录" />
	</form>
	
	<script type="text/javascript">
		var captchaBtn = document.getElementById("captchaBtn");
		captchaBtn.onclick = function() {
			var img = document.getElementById("captcha");
			img.src = "/JavaWebApp/session/code?time=" + new Date().getTime();
		}
	</script>
</body>
</html>