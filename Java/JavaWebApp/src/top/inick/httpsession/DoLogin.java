package top.inick.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//获取表单数据
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		String code = req.getParameter("code");
		String scode = (String) req.getSession().getAttribute("scode");
		System.out.println(scode + "___" + code);
		//处理业务逻辑
		if("tom".equals(username) && "123".equals(pwd)) {
			if(!code.equals(scode)) { 
				String msg = "验证码错误";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
			out.println("登录成功");
		} else {
			String msg = "账号或密码错误";
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}
