package top.inick.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		//获取表单数据
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String parameter = req.getParameter("remember");
		Cookie ck = new Cookie("userName", userName);
		ck.setPath("/");
		//处理业务逻辑
		if("tom".equals(userName) && "123".equals(password)) {
			
			if(parameter != null) {
				ck.setMaxAge(Integer.MAX_VALUE);	//cookie有效时间
			} else {
				ck.setMaxAge(0);	//删除Cookie
			}
			resp.addCookie(ck);		//将cookie写到客户端
			out.write("登录成功");
		} else {
			out.write("登录失败,两秒之后跳转登录页面");
			resp.setHeader("refresh", "2;url=" + req.getContextPath() + "/cookie/login");
		}
				
		//分发转向
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}
