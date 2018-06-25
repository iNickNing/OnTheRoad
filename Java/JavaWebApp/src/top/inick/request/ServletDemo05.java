package top.inick.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo05 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UtF-8");
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String str = "aaaaaa";
		req.setAttribute("s", str);
		
		
		System.out.println("正在转发.........");
		//请求转发 只能本应用内
		//req.getRequestDispatcher("demo06").forward(req, resp);
		//重定向 可以跳转到其他应用
		//resp.sendRedirect(req.getContextPath() + "/request/demo06");
		//请求包含
		req.getRequestDispatcher("demo06").include(req, resp);
		System.out.println(req.getContextPath());
		System.out.println("完成");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}
