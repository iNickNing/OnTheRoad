<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		/*
			Java语言创建的类
			public class person() {
				private String name;
				....
			}
		
			
		*/
		
		function Person() {
			var name = "tom";	//声明局部变量
			this.age = 10;	//声明成员变量
			this.show = function() {
				alert(name);
			}
		}
		
		var p = new Person();
		document.write(p.name);
		document.write(p.age);
		//p.show();
		
		var pp = {name:"tom",age:18};
		var p1 = {"name":"tom","age":18};
		var ppp = [{name:"tom",age:18},{name:"jack",age:18}];
		document.write(p1.name);
		
	</script>
</body>
</html>